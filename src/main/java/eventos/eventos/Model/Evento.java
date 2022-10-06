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
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="eventos")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long nroReserva;

    @Column
    private LocalDate fechaReserva;
    @Column
    private LocalDate fechaEvento;
    @Column
    private int cantidadPersonas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario", nullable = false)
    @NotNull
    private Cliente cliente ;// muchos eventos para un cliente

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSalon", nullable = false)
    @NotNull
    private Salon salon; // muchos eventos para una sala

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "eventos_servicios",
            joinColumns = @JoinColumn(name = "nroReserva", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "idServicio", nullable = false)
    )
    private Set<Servicio> servicios;

}
