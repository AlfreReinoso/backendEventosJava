package eventos.eventos.Model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idinteresado")
    @NotNull
    private Interesado interesado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idsala")
    @NotNull
    private Sala sala;

    @JoinTable(name = "evento_tiporecurso",
            joinColumns = @JoinColumn(name = "nroreserva"),
            inverseJoinColumns = @JoinColumn(name = "idtiporecurso")
    )
    @ElementCollection
    private List<TipoRecurso> tipoRecursos = new ArrayList<>();


}
