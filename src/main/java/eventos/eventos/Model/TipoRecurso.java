package eventos.eventos.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tipoRecurso")
public class TipoRecurso {

    @Id
    @GeneratedValue
    @Column
    private int idtiporecurso;

    @Column
    private String denominacion;

    @Column
    private int costopordia;

    //private ArrayList<Evento> eventos = new ArrayList<>();
    //private ArrayList<Recurso> recursos = new ArrayList<Recurso>();
}
