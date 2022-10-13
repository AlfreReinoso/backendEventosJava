package eventos.eventos.Services.salones;

import eventos.eventos.Model.Salon;
import eventos.eventos.dao.salon.SalonDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SalonesServicesImpl implements SalonesService{

    private final SalonDao salaDao;

    public List<Salon> findSalones(){
        return salaDao.findAll();
    }

    public Salon findSalonById(long id) {return salaDao.findById(id).get();}

    public Salon saveSalon(Salon salon) throws Exception{
        return salaDao.save(salon);
    }
}
