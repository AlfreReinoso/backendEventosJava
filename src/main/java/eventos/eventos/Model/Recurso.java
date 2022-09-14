package eventos.eventos.Model;

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
public class Recurso {
    @Id
    @GeneratedValue
    @Column
    private int idrecurso;

    @ManyToOne(cascade = CascadeType.ALL)

    @JoinColumn(name = "idTipoRecurso")
    @NotNull
    private TipoRecurso tiporecurso;




}
