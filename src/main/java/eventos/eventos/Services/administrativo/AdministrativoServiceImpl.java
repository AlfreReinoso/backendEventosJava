package eventos.eventos.Services.administrativo;

import eventos.eventos.Model.Administrativo;
import eventos.eventos.dao.administrativo.AdministrativoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdministrativoServiceImpl implements AdministrativoService{

    private final AdministrativoDao administrativoDao;
    @Override
    public Administrativo getAdministrativo(String usuarioName)throws Exception {
        return administrativoDao.findAdministrativoByUsuarioName(usuarioName);
    }
}
