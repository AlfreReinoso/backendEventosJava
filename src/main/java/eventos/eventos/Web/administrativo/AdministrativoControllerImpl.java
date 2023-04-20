package eventos.eventos.Web.administrativo;

import eventos.eventos.Model.Administrativo;
import eventos.eventos.Services.administrativo.AdministrativoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrativos")
@RequiredArgsConstructor
public class AdministrativoControllerImpl implements AdministrativoController {

    private final AdministrativoService administrativoService;

    @Override
    @GetMapping("/findAdministrativo/{usuarioName}")
    public Administrativo getAdministrativo(@PathVariable String usuarioName)throws Exception {
        return administrativoService.getAdministrativo(usuarioName);
    }

}
