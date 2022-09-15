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
@Table(name ="recurso")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")
public class Recurso {
    @Id
    @GeneratedValue
    @Column
    private int idrecurso;

    @ManyToOne(cascade = CascadeType.ALL) // 1 .. * : un tipo de recurso para muchos recurso
    @JoinColumn(name = "idTipoRecurso")
    @NotNull
    private TipoRecurso tiporecurso;

}
