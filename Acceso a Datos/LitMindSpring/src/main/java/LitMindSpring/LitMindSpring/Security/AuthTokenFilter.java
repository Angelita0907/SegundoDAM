package LitMindSpring.LitMindSpring.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import LitMindSpring.LitMindSpring.service.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JWTUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {
	private static final Logger logger = LogManager.getLogger(AuthTokenFilter.class);
  
	@Autowired 
   private JWTUtility jwtUtils;
   @Autowired
   private UsuarioService usuarioService;
   private String parseJwt(HttpServletRequest request) {
   	String resultado = null;
       String headerAuth = request.getHeader("Authorization");
       if (headerAuth != null && headerAuth.startsWith("Bearer")) {
       	resultado=  headerAuth.substring(6);
       }
       return resultado;
   }
   
   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
	   try {
           String jwt = parseJwt(request);
           if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
               String username = jwtUtils.getUsernameFromToken(jwt);
               UserDetails userDetails = usuarioService.loadUserByUsername(username); 
               UsernamePasswordAuthenticationToken authentication =
                       new UsernamePasswordAuthenticationToken(
                               userDetails,
                               null,
                               userDetails.getAuthorities()
                       );
               authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               SecurityContextHolder.getContext().setAuthentication(authentication);
           }
       } catch (Exception e) {
           logger.error("Cannot set user authentication: " + e);
       }
       filterChain.doFilter(request, response);
   }

}
