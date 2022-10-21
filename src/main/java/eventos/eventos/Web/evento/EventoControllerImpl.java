package eventos.eventos.Web.evento;

import eventos.eventos.Model.Evento;
import eventos.eventos.Services.evento.EventoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor
public class EventoControllerImpl implements EventoController{


    private final EventoServices eventoServices;

    @GetMapping("/findEventos")
    public List<Evento> getEventos(){
        return eventoServices.findEventos();
    }

    @GetMapping("/findEventos/{id}")
    public Evento getEventosById(@PathVariable long id){
        return eventoServices.findEventosById(id);
    }

    @PostMapping
    public Evento newEvento(@RequestBody @Valid Evento evento) {return eventoServices.newEvento(evento);  }

}
