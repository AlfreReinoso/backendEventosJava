package eventos.eventos.Services;

import eventos.eventos.Model.Evento;
import eventos.eventos.dao.EventoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EventoServices {

    private final EventoDao eventoDao;

    public List<Evento> findEventos(){
        return eventoDao.findAll();
    }

    public Evento findEventosById(long id){return eventoDao.findById(id).get();}
}
