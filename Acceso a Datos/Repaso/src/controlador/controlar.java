package controlador;

import java.time.LocalDate;

import models.Canal;
import models.Retransmision;
import models.Usuario;
import service.CanalService;
import service.UsuarioService;

public class controlar {

	public static void main(String[] args) {
		
		Usuario usu1 = new Usuario(1, "Pepito", "aa@aa", false);
		Usuario usu2 = new Usuario(2, "Juanito", "juanito@aa", true);
		Usuario usu3 = new Usuario(3, "Maria", "maria@bb", false);
		Usuario usu4 = new Usuario(4, "Carlos", "carlos@cc", true);
		Usuario usu5 = new Usuario(5, "Luisa", "luisa@dd", false);

		Canal c1 = new Canal(0, "Canal de Juanito", usu2, LocalDate.of(2025, 9, 17));
		Canal c2 = new Canal(1, "Canal de Carlos", usu4, LocalDate.of(2025, 9, 17));

		
		Retransmision r1 = new Retransmision(0, "Retransmisión de Juegos", LocalDate.of(2025, 9, 18), LocalDate.of(2025, 9, 18), c2);
		Retransmision r2 = new Retransmision(1, "Retransmisión de Noticias", LocalDate.of(2025, 9, 19), LocalDate.of(2025, 9, 19), c1);
		Retransmision r3 = new Retransmision(2, "Retransmisión de Música en Vivo", LocalDate.of(2025, 9, 20), LocalDate.of(2025, 9, 20), c1);
		Retransmision r4 = new Retransmision(3, "Retransmisión de Películas", LocalDate.of(2025, 9, 21), LocalDate.of(2025, 9, 21), c2);
		Retransmision r5 = new Retransmision(4, "Retransmisión de Entrevistas", LocalDate.of(2025, 9, 22), LocalDate.of(2025, 9, 22), c2);
		
		//usuarios
		UsuarioService usuServ = new UsuarioService();
		
		usuServ.altaUsuario(usu1);
		usuServ.altaUsuario(usu2);
		usuServ.altaUsuario(usu3);
		usuServ.altaUsuario(usu4);
		usuServ.altaUsuario(usu5);
		
		usuServ.borrarUsuario(usu4);
		
		usuServ.buscarUsuario(usu3);
		
		System.out.println(usuServ.getUsuRepo().getUsuarios());
		
		//canal
		CanalService canalServ = new CanalService();
		canalServ.altaCanal(c1);
		canalServ.altaCanal(c2);

		System.out.println(canalServ);
		
		
	}

}
