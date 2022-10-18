package eventos.eventos.Web.cliente;


import eventos.eventos.Model.Cliente;
import eventos.eventos.Services.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;

    @Override
    @GetMapping("/findClientes")
    public List<Cliente> getClientes() throws Exception {
        return clienteService.findClientes();
    }
}
