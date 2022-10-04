package eventos.eventos.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
    @JoinColumn(name = "idusuario")
    @NotNull
    private Usuario usuario ;// muchos eventos para un interesado

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idsalon")
    @NotNull
    private Salon salon; // muchos eventos para una sala

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "evento_tiposervicios",
            joinColumns = @JoinColumn(name = "nroreserva"),
            inverseJoinColumns = @JoinColumn(name = "idtiposervicio")
    )
    private List<TipoServicio> tipoServicios = new ArrayList<>();


}
