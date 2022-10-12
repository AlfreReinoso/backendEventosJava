package eventos.eventos.Services.servicio;

import eventos.eventos.Model.Servicio;
import eventos.eventos.dao.servicio.ServicioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService{

    private final ServicioDao servicioDao;

    @Override
    public Servicio findServicio(int idServicio) throws Exception {
        return servicioDao.findById(idServicio);
    }
}
