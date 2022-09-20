package eventos.eventos.Services;

import eventos.eventos.Model.Sala;
import eventos.eventos.dao.SalaDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SalaServices {

    private final SalaDao salaDao;

    public List<Sala> findSalas(){
        return salaDao.findAll();
    }
}
