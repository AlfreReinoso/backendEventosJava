package eventos.eventos.dao.servicio;

import eventos.eventos.Model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicioDao extends JpaRepository<Servicio, Integer> {

    Servicio findById(int idServicio);

    Servicio findByDenominacion( String denominacion);

    @Modifying
    @Query(nativeQuery = true, value =
            "DELETE FROM eventos_servicios WHERE id_servicio = ?1")
    void DeleteEventoServicios(int idServicio);
}
