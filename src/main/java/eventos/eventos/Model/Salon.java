package eventos.eventos.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name ="salon")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")

public class Salon {
    @Id
    @GeneratedValue
    @Column
    private int idsalon;
    @Column
    private String denominacion;
    @Column
    private int capacidad;
    @Column
    private int costopordia;

    @OneToMany(mappedBy = "nroreserva") // una sala para muchos eventos
    private List<Evento> eventos = new ArrayList<>();

}
