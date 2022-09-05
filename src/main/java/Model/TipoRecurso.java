package Model;

import java.util.ArrayList;

public class TipoRecurso {
    private int idTipoRecurso;
    private String denominacion;
    private int costoPorDia;
    private ArrayList<Evento> eventos = new ArrayList<>();
    private ArrayList<Recurso> recursos = new ArrayList<Recurso>();
}
