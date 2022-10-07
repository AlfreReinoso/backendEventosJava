package eventos.eventos.Services.tipoServicio;

import eventos.eventos.Model.TipoServicio;
import eventos.eventos.dao.tipoServicio.TipoServicioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TipoSercivioServiceImpl implements TipoServicioService {

    private final TipoServicioDao tipoServicioDao;

    @Override
    public TipoServicio findTipoServicio(int idTipoServicio) {
        return tipoServicioDao.findById(idTipoServicio);
    }
}
