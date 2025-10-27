package service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.InteraccionAgente;
import models.TipoAgente;
import repository.RepositorioInteracciones;

public class ServicioEstadisticaImpl {

	private static final Logger logger = LogManager.getLogger(ServicioEstadisticaImpl.class);

	private RepositorioInteracciones repoInteraccioes;
	
	// instancio aqui la lista porque la uso en varios metodos y me parecia redundante hacerlo en todos igual
	ArrayList<InteraccionAgente> listaInteracciones = repoInteraccioes.getListaInteracciones();

	public ServicioEstadisticaImpl(RepositorioInteracciones repoInteraccioes) {
		super();
		this.repoInteraccioes = repoInteraccioes;
	}

	public RepositorioInteracciones getRepoInteraccioes() {
		return repoInteraccioes;
	}

	public void setRepoInteraccioes(RepositorioInteracciones repoInteraccioes) {
		this.repoInteraccioes = repoInteraccioes;
	}

	// funciones del repositorio

	public void incrementarNumeroValoraciones(String id) {
		repoInteraccioes.incrementarNumeroValoraciones(id);
	}

	public void addInteraccionRegistro(InteraccionAgente i) {
		repoInteraccioes.agregarInteraccionARegistro(i);
	}

	public void actualizarPorcentaje(InteraccionAgente interaccion, double porcentajeNuevo) {
		repoInteraccioes.actualizaPorcentajeInteraccion(interaccion, porcentajeNuevo);
	}
	

	public InteraccionAgente obtenerInteraccionConMejorValoracion() {
		
		//voy a comprar por las posiciones de la lista y con eso que guarde la mejor
		
		InteraccionAgente mejorValoracion = listaInteracciones.get(0);
		
		// empieza en la posisicon 1 ya que primero cogimos la 0 para asignar cual coger primero
		for(int i = 1; i < listaInteracciones.size(); i++) {
			InteraccionAgente valoracionActual = listaInteracciones.get(i);
			if(valoracionActual.getNumValoracionesPositivas() > mejorValoracion.getNumValoracionesPositivas()) {
				mejorValoracion = valoracionActual;
			}
		}
		return mejorValoracion;
	}
	

	public Map<TipoAgente, List<InteraccionAgente>> mostrarInteraccionAgrupadasPorTipo(
			HashSet<InteraccionAgente> listaInteracciones, TipoAgente tipo) {

		Map<TipoAgente, List<InteraccionAgente>> interaccionTipo = new HashMap<TipoAgente, List<InteraccionAgente>>();

		if (tipo == TipoAgente.IA) {
			interaccionTipo = agruparPorIA(listaInteracciones);
		} else if (tipo == TipoAgente.HUMANO) {
			interaccionTipo = agruparPorHumano(listaInteracciones);
		}

		return interaccionTipo;
	}

	public Map<TipoAgente, List<InteraccionAgente>> agruparPorIA(HashSet<InteraccionAgente> interacciones) {

		Map<TipoAgente, List<InteraccionAgente>> interaccionesIA = new HashMap<TipoAgente, List<InteraccionAgente>>();
		List<InteraccionAgente> listaInteraccionesIA = new ArrayList<>();

		for (InteraccionAgente i : interacciones) {
			if (i.getTipoAgente() == TipoAgente.IA) {
				listaInteraccionesIA.add(i);
			}
		}
		interaccionesIA.put(TipoAgente.IA, listaInteraccionesIA);

		return interaccionesIA;
	}

	public Map<TipoAgente, List<InteraccionAgente>> agruparPorHumano(HashSet<InteraccionAgente> interacciones) {

		Map<TipoAgente, List<InteraccionAgente>> interaccionesHumano = new HashMap<TipoAgente, List<InteraccionAgente>>();
		List<InteraccionAgente> listaInteraccionesHumano = new ArrayList<>();

		for (InteraccionAgente i : interacciones) {
			if (i.getTipoAgente() == TipoAgente.HUMANO) {
				listaInteraccionesHumano.add(i);
			}
		}
		interaccionesHumano.put(TipoAgente.IA, listaInteraccionesHumano);

		return interaccionesHumano;
	}

	public void grabarResumenEstadistica(String ruta) {

	}

	public String obtenerinteraccionesAciertoMayorOrdenadas(double porcentajeAcierto) {

		return null;
	}

	public void grabarFicheroCSV(List<InteraccionAgente> listaInteracciones, String ruta) {

		PrintWriter out = null;
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(ruta);
			out = new PrintWriter(fichero);
			// fichero.write(json);

			// asi se escribe un fichero:
			// pongo la cabezara fuera para que la escriba una sola vez, que si no en el
			// bucle no para
			out.printf(Locale.US,
					"Identificador,Tipo,Peticion,Respuesta,TiempoEjecucion,Valoraciones,PorcentajeAcierto");

			for (InteraccionAgente interaccion : listaInteracciones) {
				out.printf(Locale.US, "%s,%s,%s,%s,%.3f,%d,%.2f%n", interaccion.getIdentificador(),
						interaccion.getTipoAgente(), interaccion.getPeticion(), interaccion.getRespuesta(),
						interaccion.getTiempoEjecucion(), interaccion.getNumValoracionesPositivas(),
						interaccion.getPorcentajeAcierto());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fichero != null) {
				try {
					fichero.close();
					out.close();
				} catch (IOException e) {
					System.out.println("Error al escribir fichero csv de interacciones");
				}
			}
		}

	}

	public void cargarRegistrosDesdeJSON(List<InteraccionAgente> listaInteracciones, String ruta) {

		// como ya tenemos el fichero csv no hace falta usarlo: leer y luego crear
		// ya que los datos los pasamos por consola y los guardo en una lista podemos
		// directamente
		// escribir sin leer el fichero anterior

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(listaInteracciones);
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(ruta);
			fichero.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println("Error al escribir fichero json de interacciones");
				}

			}

		}

	}

	public double obtenerTiempoMedioPorAgente(TipoAgente agente) {
		
		double tiempoAgente = 0;
		int contaddor = 0;
		
		for (InteraccionAgente interaccion : listaInteracciones) {
			if(interaccion.getTipoAgente() == agente) {
				tiempoAgente = tiempoAgente + interaccion.getTiempoEjecucion();
				contaddor ++;
			}
		}
		
		double mediaEjecucion = tiempoAgente / contaddor;

		return mediaEjecucion;
	}

	public double obtenerPorcentajeMedioPorAgente(TipoAgente agente) {

		// es como la anterior pero cogemos el porcentaje en vez de la ejecución
		double aciertoAgente = 0;
		int contaddor = 0;
		
		for (InteraccionAgente interaccion : listaInteracciones) {
			if(interaccion.getTipoAgente() == agente) {
				aciertoAgente = aciertoAgente + interaccion.getPorcentajeAcierto();
				contaddor ++;
			}
		}
		
		double mediaAcierto = aciertoAgente / contaddor;

		return mediaAcierto;
	}

}
