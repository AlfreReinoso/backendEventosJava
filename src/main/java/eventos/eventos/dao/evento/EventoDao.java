package eventos.eventos.dao.evento;

import eventos.eventos.Model.Evento;
import jdk.jfr.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoDao extends JpaRepository<Evento, Long> {


}
