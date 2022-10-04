package eventos.eventos.Web;

import eventos.eventos.Model.Salon;
import eventos.eventos.Services.SalonesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/salas")
@RequiredArgsConstructor
public class SalaController {

    private final SalonesServices salonesServices;


    @GetMapping("/findSalas")
    public List<Salon> getSalones(){
        return salonesServices.findSalones();
    }


}
