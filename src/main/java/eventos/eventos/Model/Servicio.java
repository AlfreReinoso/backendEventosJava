package eventos.eventos.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="servicio")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")
public class Servicio {
    @Id
    @GeneratedValue
    @Column
    private int idservicio;

    @ManyToOne(cascade = CascadeType.ALL) // 1 .. * : un tipo de recurso para muchos recurso
    @JoinColumn(name = "idTipoServicio")
    @NotNull
    private TipoServicio tiposervicio;

    @Column
    private String denominacion;

}
