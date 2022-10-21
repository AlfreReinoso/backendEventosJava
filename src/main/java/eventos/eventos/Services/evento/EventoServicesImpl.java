package eventos.eventos.Services.evento;

import eventos.eventos.Model.Evento;
import eventos.eventos.Model.Salon;
import eventos.eventos.Model.Servicio;
import eventos.eventos.dao.cliente.ClienteDao;
import eventos.eventos.dao.evento.EventoDao;
import eventos.eventos.dao.salon.SalonDao;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class EventoServicesImpl implements EventoService{

    private final EventoDao eventoDao;
    private final SalonDao salonDao;
    private final ClienteDao clienteDao;

    @Override
    public List<Evento> findEventos() throws Exception{

        return eventoDao.findAll();
    }

    @Override
    public Evento findEventosById(long id)throws Exception{
        return eventoDao.findById(id).get();
    }

    @Override
    public Evento newEvento ( Evento evento )throws Exception{
        /*Salon salonDB = salaDao.findById(salon.getIdSalon())
                .orElseThrow(() -> new NotFoundException("No existe el salon"));*/

        // Valida que exista un salon
        long idSalonDb = evento.getSalon().getIdSalon();
        salonDao.findById(idSalonDb).orElseThrow(()->new NotFoundException("No existe el salon"));

        // Valida que exista un cliente
        long idClienteDb = evento.getCliente().getIdUsuario();
        clienteDao.findById(idClienteDb).orElseThrow(()->new NotFoundException("No existe el Cliente ingresado"));

        /*Set<Servicio> serviciosParam = evento.getServicios();
        if( serviciosParam != null){
            serviciosParam.forEach();
        }*/

        /*if(salonDao.findById(idsalonDb).get() == null){
            throw new Exception("No existe el salon ingresado");
        }*/
        return eventoDao.saveAndFlush(evento);
    }
}
