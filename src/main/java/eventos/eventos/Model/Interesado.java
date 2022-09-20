package eventos.eventos.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="interesado")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")

public class Interesado {
    @Id
    @Column
    @GeneratedValue
    private int idinteresado;
    @Column
    private String tipodocumento;
    @Column
    private String nrodocumento;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private String mail;
    @Column
    private String telefono;

    @OneToMany(mappedBy = "nroreserva") // un interesado para muchos eventos
    @NotNull
    private List<Evento> eventos = new ArrayList<>();

}
