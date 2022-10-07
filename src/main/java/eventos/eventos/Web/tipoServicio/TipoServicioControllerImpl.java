package eventos.eventos.Web.tipoServicio;

import eventos.eventos.Model.TipoServicio;
import eventos.eventos.Services.tipoServicio.TipoServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tiposervicio")
@RequiredArgsConstructor
public class TipoServicioControllerImpl implements TipoServicioController {

    private final TipoServicioService tipoServicioService;

    @Override
    @GetMapping("/findTipoServicio")
    @ResponseStatus(HttpStatus.OK)
    public TipoServicio findTipoServicio(@RequestParam(name = "idTipoServicio") int idTipoServicio) throws Exception {
        return tipoServicioService.findTipoServicio(idTipoServicio);
    }

}
