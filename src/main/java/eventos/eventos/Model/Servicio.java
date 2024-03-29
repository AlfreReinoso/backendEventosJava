package eventos.eventos.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="servicios")
// @JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idServicio;

    @Column
    private String denominacion;

    @Column
    private double costoPorDia;

    @ManyToOne
    @JoinColumn(name = "idTipoServicio", nullable = false)
    @NotNull
    private TipoServicio tipoServicio;
//
//    @ManyToMany(mappedBy = "servicios")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Set<Evento> eventos ;

}
