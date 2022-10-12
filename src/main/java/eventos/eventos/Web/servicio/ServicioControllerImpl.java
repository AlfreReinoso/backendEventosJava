package eventos.eventos.Web.servicio;

import eventos.eventos.Model.Servicio;
import eventos.eventos.Services.servicio.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicio")
@RequiredArgsConstructor
public class ServicioControllerImpl implements ServicioController {

    private final ServicioService servicioService;

    @Override
    @GetMapping("/findServicio")
    @ResponseStatus(HttpStatus.OK)
    public Servicio findServicio(int idServicio) throws Exception {
        return servicioService.findServicio(idServicio);
    }
}
