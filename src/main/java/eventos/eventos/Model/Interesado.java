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
@Table(name ="interesado")
public class Interesado {
    @Id
    @Column
    @GeneratedValue
    private int idinteresado;
    @Column
    private String tipodocumento;
    @Column
    private int nrodocumento;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private String mail;
    @Column
    private int telefono;

    //private ArrayList<Evento> eventos = new ArrayList<>();

}
