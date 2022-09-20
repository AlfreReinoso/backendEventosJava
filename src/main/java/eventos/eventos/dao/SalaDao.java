package eventos.eventos.dao;

import eventos.eventos.Model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaDao extends JpaRepository<Sala, Long> {

    List<Sala> findAll();

}
