package eventos.eventos.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="sala")
public class Sala {
    @Id
    @GeneratedValue
    @Column
    private int idsala;
    @Column
    private String denominacion;
    @Column
    private int capacidad;
    @Column
    private int costopordia;
    //private ArrayList<Evento> eventos = new ArrayList<>();

}
