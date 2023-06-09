package eventos.eventos.Web.salon;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import eventos.eventos.Model.Salon;
import eventos.eventos.Model.TipoServicio;
import eventos.eventos.Services.Imagenes.StorageServices;
import eventos.eventos.Services.salones.SalonesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/salas")
@RequiredArgsConstructor
public class SalonControllerImpl implements SalonController {

    private final SalonesService salonesServices;
    private final StorageServices storageServices;
    private final HttpServletRequest httpServletRequest;



    @GetMapping("/findSalas")
    public List<Salon> getSalones() throws Exception {
        return salonesServices.findSalones();
    }

    @GetMapping("/{id}")
    public Salon getSalon(@PathVariable long id) throws Exception {return salonesServices.findSalonById(id);}

    @PutMapping("/update")
    public Salon updateSalon(@RequestParam("file") MultipartFile multipartFile,@RequestBody @Valid Salon salon) throws Exception {
        String path = storageServices.store(multipartFile);
        String host = httpServletRequest.getRequestURL().toString().replace(httpServletRequest.getRequestURI(),"");
        String url = ServletUriComponentsBuilder
                .fromHttpUrl(host)
                .path("/media/")
                .path(path)
                .toUriString();
        salonesServices.saveImg(url, (int) salon.getIdSalon());
        return salonesServices.updateSalon(salon);
    }
    @PostMapping("/savesalon")
    @ResponseStatus(HttpStatus.CREATED)
    public Salon saveSalon(@RequestParam("file") MultipartFile multipartFile,@RequestBody Salon salon) throws Exception {
        String path = storageServices.store(multipartFile);
        String host = httpServletRequest.getRequestURL().toString().replace(httpServletRequest.getRequestURI(),"");
        String url = ServletUriComponentsBuilder
                .fromHttpUrl(host)
                .path("/media/")
                .path(path)
                .toUriString();
        Salon salonToSave = salonesServices.saveSalon(salon);
        salonesServices.saveImg(url, (int) salonToSave.getIdSalon());
        return salonToSave;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSalon(@PathVariable long id) throws Exception {
        salonesServices.deleteById(id);
    }
}
