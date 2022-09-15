package eventos.eventos.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
@Table(name = "tiporecurso")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")

public class TipoRecurso {

    @Id
    @GeneratedValue
    @Column
    private int idtiporecurso;

    @Column
    private String denominacion;

    @Column
    private int costopordia;


    @ManyToMany(mappedBy = "tipoRecursos")
    private List<Evento> eventos = new ArrayList<>();

    @OneToMany(mappedBy = "idrecurso")
    @NotNull
    private List<Recurso> recursos = new ArrayList<>();
}
