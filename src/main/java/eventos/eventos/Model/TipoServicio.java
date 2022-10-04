package eventos.eventos.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tiposervicio")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")

public class TipoServicio {

    @Id
    @GeneratedValue
    @Column
    private int idtiposervicio;

    @Column
    private String denominacion;

    @Column
    private int costopordia;

    @ManyToMany(mappedBy = "tipoServicios")
    private List<Evento> eventos = new ArrayList<>();


    @OneToMany(mappedBy = "idservicio")
    @NotNull
    private List<Servicio> recursos = new ArrayList<>();
}
