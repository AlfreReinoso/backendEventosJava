package eventos.eventos.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tiporecurso")
public class TipoRecurso {

    @Id
    @GeneratedValue
    @Column
    private int idtiporecurso;

    @Column
    private String denominacion;

    @Column
    private int costopordia;


    @ManyToMany(mappedBy = "tipoRecursos")
    private List<Evento> eventos = new ArrayList<>();
    //private ArrayList<Recurso> recursos = new ArrayList<Recurso>();
}
