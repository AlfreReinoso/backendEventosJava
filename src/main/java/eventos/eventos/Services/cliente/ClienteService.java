package eventos.eventos.Services.cliente;

import eventos.eventos.Model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ClienteService {
    List<Cliente> findClientes() throws Exception;

}
