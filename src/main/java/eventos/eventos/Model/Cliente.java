package eventos.eventos.Model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="clientes")
public class Cliente extends Usuario{
    @OneToMany(mappedBy = "nroReserva")
    private Set<Evento> eventos;

}
