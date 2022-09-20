package eventos.eventos.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")
public class Evento {
    @Id
    @GeneratedValue
    @Column
    private long nroreserva;

    @Column
    private Date fechareserva;
    @Column
    private Date fechaevento;
    @Column
    private int cantpersonas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idinteresado")
    @NotNull
    private Interesado interesado; // muchos eventos para un interesado

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idsala")
    @NotNull
    private Sala sala; // muchos eventos para una sala



    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "evento_tiporecurso",
            joinColumns = @JoinColumn(name = "nroreserva"),
            inverseJoinColumns = @JoinColumn(name = "idtiporecurso")
    )
    private List<TipoRecurso> tipoRecursos = new ArrayList<>();


}
