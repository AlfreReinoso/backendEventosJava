package eventos.eventos.Web.administrativo;

import eventos.eventos.Model.Administrativo;

public interface AdministrativoController {
    Administrativo getAdministrativo(String usuarioName) throws Exception;
}
