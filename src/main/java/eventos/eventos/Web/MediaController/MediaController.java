package eventos.eventos.Web.MediaController;

import eventos.eventos.Services.Imagenes.StorageServices;
import eventos.eventos.Services.salones.SalonesService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@RestController
@RequestMapping("media")
@AllArgsConstructor
public class MediaController {
    private final StorageServices storageServices;
    private final HttpServletRequest httpServletRequest;
    private final SalonesService salonesService;

    @PostMapping("upload")
    public Map<String, String> uploadFile(@RequestParam("file")MultipartFile multipartFile, Integer idSalon) throws Exception {
        String path = storageServices.store(multipartFile);
        String host = httpServletRequest.getRequestURL().toString().replace(httpServletRequest.getRequestURI(),"");
        String url = ServletUriComponentsBuilder
                .fromHttpUrl(host)
                .path("/media/")
                .path(path)
                .toUriString();
        salonesService.saveImg(url,idSalon);
        return Map.of("url", url);
    }

    @GetMapping("{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException{
        Resource file = storageServices.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);
    }
}
