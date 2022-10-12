package eventos.eventos.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipos_servicios")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")
public class TipoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idTipoServicio;

    @Column
    @NotNull
    private String denominacion;

//    @OneToMany(mappedBy = "idServicio", cascade = {CascadeType.ALL})
//    private List<Servicio> servicios = new ArrayList<>();

}
