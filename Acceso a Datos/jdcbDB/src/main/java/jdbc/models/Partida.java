package jdbc.models;

import java.util.Date; // Usar java.time.LocalDate si estás en Java 8+

import jdbc.utiles.ResultadoPartida;

public class Partida {

    private int id;
    private int torneoId; 
    private Jugador narradorId; 
    private Date fecha;
    private ResultadoPartida resultado; 

    // Constructor vacío
    public Partida() {
    }

    // Constructor completo
    public Partida(int id, int torneoId, Jugador narradorId, Date fecha, ResultadoPartida resultado) {
        this.id = id;
        this.torneoId = torneoId;
        this.narradorId = narradorId;
        this.fecha = fecha;
        this.resultado = resultado;
    }

    // --- Getters y Setters ---

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTorneoId() {
        return torneoId;
    }

    public void setTorneoId(Integer torneoId) {
        this.torneoId = torneoId;
    }

    public Jugador getNarradorId() {
        return narradorId;
    }

    public void setNarradorId(Jugador narradorId) {
        this.narradorId = narradorId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ResultadoPartida getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoPartida resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", torneoId=" + torneoId +
                ", narradorId=" + narradorId +
                ", fecha=" + fecha +
                ", resultado=" + resultado +
                '}';
    }
}