package eventos.eventos.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="evento")
public class Evento {
    @Id
    @GeneratedValue
    @Column
    private int nroreserva;

    @Column
    private Date fechareserva;
    @Column
    private Date fechaevento;
    @Column
    private int cantpersonas;
   // private Interesado interesado;
    //private Sala sala;
    //private ArrayList<TipoRecurso> tipoRecursos = new ArrayList<TipoRecurso>();

}
