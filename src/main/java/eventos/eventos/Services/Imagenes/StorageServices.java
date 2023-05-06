package eventos.eventos.Services.Imagenes;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface StorageServices {
    void init() throws IOException;

    String store(MultipartFile multiPartFile);

    Resource loadAsResource(String filename);

}
