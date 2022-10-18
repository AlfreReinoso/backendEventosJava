package eventos.eventos.Web.cliente;

import eventos.eventos.Model.Cliente;

import java.util.List;

public interface ClienteController {
    List<Cliente> getClientes() throws Exception;
}
