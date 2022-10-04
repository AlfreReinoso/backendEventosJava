package eventos.eventos.Model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name ="cliente")
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Usuario{
}
