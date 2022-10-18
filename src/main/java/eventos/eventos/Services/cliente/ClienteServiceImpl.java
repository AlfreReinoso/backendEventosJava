package eventos.eventos.Services.cliente;

import eventos.eventos.Model.Cliente;
import eventos.eventos.dao.cliente.ClienteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService{

    private final ClienteDao clienteDao;

    @Override
    public List<Cliente> findClientes() throws Exception {
        return clienteDao.findAll();
    }
}
