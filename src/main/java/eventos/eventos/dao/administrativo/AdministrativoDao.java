package eventos.eventos.dao.administrativo;

import eventos.eventos.Model.Administrativo;
import eventos.eventos.Services.administrativo.AdministrativoService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrativoDao extends JpaRepository<Administrativo,Long> {
    Administrativo findAdministrativoByUsuarioName(String usuarioName) throws Exception;
}
