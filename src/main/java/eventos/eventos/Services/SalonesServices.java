package eventos.eventos.Services;

import eventos.eventos.Model.Salon;
import eventos.eventos.dao.SalonDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SalonesServices {

    private final SalonDao salaDao;

    public List<Salon> findSalones(){
        return salaDao.findAll();
    }
}
