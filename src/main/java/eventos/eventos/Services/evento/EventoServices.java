package eventos.eventos.Services.evento;

import eventos.eventos.Model.Evento;
import eventos.eventos.dao.evento.EventoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EventoServices implements EventoService{

    private final EventoDao eventoDao;

    public List<Evento> findEventos(){
        return eventoDao.findAll();
    }

    public Evento findEventosById(long id){return eventoDao.findById(id).get();}

    public Evento newEvento ( Evento evento ){
        return eventoDao.save(evento);
    }
}
