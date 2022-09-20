package eventos.eventos.Web;

import eventos.eventos.Model.Sala;
import eventos.eventos.Services.SalaServices;
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

    private final SalaServices salaServices;


    @GetMapping("/findSalas")
    public List<Sala> getSalas(){
        return salaServices.findSalas();
    }
}
