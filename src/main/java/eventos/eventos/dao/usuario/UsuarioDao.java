package eventos.eventos.dao.usuario;

import eventos.eventos.Model.Evento;
import eventos.eventos.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    // List<Usuario> findAll();

}
