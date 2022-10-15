package eventos.eventos.Web.tipoServicio;

import eventos.eventos.Model.TipoServicio;
import eventos.eventos.Services.tipoServicio.TipoServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoServicio")
@RequiredArgsConstructor
public class TipoServicioControllerImpl implements TipoServicioController {

    private final TipoServicioService tipoServicioService;

    @Override
    @PostMapping("/saveTipoServicio")
    @ResponseStatus(HttpStatus.CREATED)
    public TipoServicio saveTipoServicio(@RequestBody TipoServicio tipoServicio) throws Exception {
        return tipoServicioService.saveTipoServicio(tipoServicio);
    }

    @Override
    @GetMapping("/findTipoServicio")
    @ResponseStatus(HttpStatus.OK)
    public TipoServicio findTipoServicio(@RequestParam(name = "idTipoServicio") int idTipoServicio) throws Exception {
        return tipoServicioService.findTipoServicio(idTipoServicio);
    }

    @Override
    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<TipoServicio> findAll() throws Exception {
        return tipoServicioService.findAll();
    }
}
