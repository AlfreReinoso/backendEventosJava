package eventos.eventos.Services.evento;

import eventos.eventos.Model.Cliente;
import eventos.eventos.Model.Evento;
import eventos.eventos.Model.Salon;
import eventos.eventos.Model.Servicio;
import eventos.eventos.dao.cliente.ClienteDao;
import eventos.eventos.dao.evento.EventoDao;
import eventos.eventos.dao.salon.SalonDao;
import eventos.eventos.dao.servicio.ServicioDao;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EventoServicesImpl implements EventoService{

    private final EventoDao eventoDao;
    private final SalonDao salonDao;
    private final ClienteDao clienteDao;
    private final ServicioDao servicioDao;

    @Override
    public List<Evento> findEventos() throws Exception{

        return eventoDao.findAll();
    }

    @Override
    public Evento findEventosById(long id)throws Exception{
        return eventoDao.findById(id).get();
    }

    public Evento[] findEventosByCliente(long id)throws Exception{
        return eventoDao.findAllByCliente_IdUsuario(id);
    }

    @Override
    public Evento newEvento ( Evento evento )throws Exception {

        if (evento.getFechaEvento().isBefore(LocalDate.now())) {
            throw new Exception("La fecha de Evento ingresada es anterior a la fecha de hoy");
        }

        // Valida que exista un salon
        long idSalonDb = evento.getSalon().getIdSalon();
        Salon salonDb = salonDao.findById(idSalonDb).orElseThrow(() -> new NotFoundException("No existe el salon"));

        List<Evento> eventos = eventoDao.findAll();
        for (Evento event : eventos) {
            if (evento.getFechaEvento() == event.getFechaEvento()) {
                if (evento.getSalon() == event.getSalon()) {
                    throw new Exception("Ya existe un evento para ese salon en esa fecha");
                }
            }
        }

            if (!(evento.getCantidadPersonas() < salonDb.getCapacidad())) {
                throw new Exception("La cantidad de personas ingresada es mayor a la capacidad del salon");
            }

            // Valida que exista un cliente
            long idClienteDb = evento.getCliente().getIdUsuario();
            Cliente clienteDb = clienteDao.findById(idClienteDb).orElseThrow(() -> new NotFoundException("No existe el Cliente ingresado"));

            // Valida que existan los servicios
            Set<Servicio> serviciosParam = evento.getServicios();
            if (serviciosParam != null) {
                for (Servicio servicio : serviciosParam) {
                    if (servicioDao.findById(servicio.getIdServicio()) == null) {
                        throw new Exception("No existe el servicio ingresado");
                    }
                }
            }

        System.out.println(serviciosParam);
            return eventoDao.save(evento);
        }


    @Override
    public Evento updateEvento(Evento evento) throws Exception {

        if(evento.getFechaEvento().isBefore(LocalDate.now())){
            throw new Exception("La fecha de Evento ingresada es anterior a la fecha de hoy");
        }

        // Valida que exista un salon
        String nomSalonDb = evento.getSalon().getDenominacion();
        Salon salonDb = salonDao.findSalonByDenominacion(nomSalonDb);
        //.orElseThrow(()->new NotFoundException("No existe el salon"));

        List<Evento> eventoss = eventoDao.findAll();
        for(Evento event:eventoss){
            if(evento.getFechaEvento().equals(event.getFechaEvento())){
                if(evento.getSalon().equals(event.getSalon())){
                    throw new Exception("Ya existe un evento para ese salon en esa fecha");
                }
        }

        if(salonDb == null){
            throw new Exception("No existe el nombre del salon");
        }

        }
        if(!(evento.getCantidadPersonas() < salonDb.getCapacidad())){
            throw new Exception("La cantidad de personas ingresada es mayor a la capacidad del salon");
        }

        // Valida que exista un cliente
        Cliente clienteDb = clienteDao.findById(evento.getCliente().getIdUsuario()).get();
                //.orElseThrow(()->new NotFoundException("No existe el Cliente ingresado"));

        if(clienteDb == null){
            throw new Exception("No existe el cliente");
        }

        // Valida que existan los servicios
        Set<Servicio> serviciosParam = evento.getServicios();
        Set<Servicio> serviciosToSave= new HashSet<>();
        if( serviciosParam != null){
            for(Servicio servicio : serviciosParam){
                Servicio varlocal = servicioDao.findById(servicio.getIdServicio());
                // System.out.println(varlocal);

                if( varlocal==null
                ){
                    throw new Exception("No existe el servicio ingresado");
                }else {
                    serviciosToSave.add(varlocal);
                }
            }
        }

        evento.setServicios(serviciosToSave);
        return eventoDao.save(evento);
    }

    @Override
    public void deleteEvento(long id) throws Exception{
        eventoDao.deleteById(id);
    }

}
