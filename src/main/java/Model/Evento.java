package Model;

import java.util.ArrayList;
import java.util.Date;

public class Evento {
    private int nroReserva;
    private Date fechaReserva;
    private Date fechaEvento;
    private int cantPersonas;
    private Interesado interesado;
    private Sala sala;
    private ArrayList<TipoRecurso> tipoRecursos = new ArrayList<TipoRecurso>();

}
