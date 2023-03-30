package eventos.eventos.Services.administrativo;

import eventos.eventos.Model.Administrativo;

public interface AdministrativoService {
    Administrativo getAdministrativo(String usuarioName) throws Exception;
}
