package eventos.eventos.Web.salon;

import eventos.eventos.Model.Salon;
import eventos.eventos.Model.TipoServicio;
import eventos.eventos.Services.salones.SalonesServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/salas")
@RequiredArgsConstructor
public class SalonControllerImpl implements SalonController {

    private final SalonesServicesImpl salonesServices;


    @GetMapping("/findSalas")
    public List<Salon> getSalones(){
        return salonesServices.findSalones();
    }

    @GetMapping("/{id}")
    public Salon getSalon(@PathVariable long id){return salonesServices.findSalonById(id);}


    @PostMapping("/savesalon")
    @ResponseStatus(HttpStatus.CREATED)
    public Salon saveSalon(@RequestBody Salon salon) throws Exception {
        return salonesServices.saveSalon(salon);
    }
}
