package eventos.eventos.Services.tipoServicio;

import eventos.eventos.Model.TipoServicio;
import eventos.eventos.Services.servicio.ServicioService;
import eventos.eventos.dao.servicio.ServicioDao;
import eventos.eventos.dao.tipoServicio.TipoServicioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TipoServicioServiceImpl implements TipoServicioService {

    private final TipoServicioDao tipoServicioDao;
    private final ServicioDao servicioDao;
    private final ServicioService servicioService;

    @Override
    public TipoServicio saveTipoServicio(TipoServicio tipoServicio) throws Exception {
        return tipoServicioDao.saveAndFlush(tipoServicio);
    }

    @Override
    public TipoServicio updateTipoServicio(TipoServicio tipoServicio) throws Exception {
        return tipoServicioDao.saveAndFlush(tipoServicio);
    }

    @Override
    public TipoServicio findTipoServicio(int idTipoServicio) throws Exception {
        return tipoServicioDao.findById(idTipoServicio);
    }

    @Override
    public List<TipoServicio> findAll() throws Exception {
        return tipoServicioDao.findAll();
    }

    @Override
    public void deleteTipoServicio(int idTipoServicio) throws Exception {
        servicioDao.findAllByTipoServicio_IdTipoServicio(idTipoServicio).stream().map(servicio -> {
            try {
                servicioService.deleteServicio(servicio.getIdServicio());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        tipoServicioDao.deleteById(idTipoServicio);
    }
}
