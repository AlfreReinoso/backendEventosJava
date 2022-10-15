package eventos.eventos.Services.tipoServicio;

import eventos.eventos.Model.TipoServicio;
import eventos.eventos.dao.tipoServicio.TipoServicioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TipoSercivioServiceImpl implements TipoServicioService {

    private final TipoServicioDao tipoServicioDao;

    @Override
    public TipoServicio saveTipoServicio(TipoServicio tipoServicio) throws Exception {
        return tipoServicioDao.saveAndFlush(tipoServicio);
    }

    @Override
    public TipoServicio updateTipoServicio(TipoServicio tipoServicio) throws Exception {
        return tipoServicioDao.saveAndFlush(tipoServicio);
    }

    @Override
    public TipoServicio findTipoServicio(int idTipoServicio) {
        return tipoServicioDao.findById(idTipoServicio);
    }

    @Override
    public List<TipoServicio> findAll() {
        return tipoServicioDao.findAll();
    }

    @Override
    public void deleteTipoServicio(TipoServicio tipoServicio) throws Exception {
        tipoServicioDao.deleteById(tipoServicio.getIdTipoServicio());
    }
}
