package eventos.eventos.dao.tipoServicio;

import eventos.eventos.Model.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TipoServicioDao extends JpaRepository<TipoServicio, Integer> {

    TipoServicio findById(int idTipoServicio);

    @Modifying
    @Query(nativeQuery = true, value =
            "DELETE FROM eventos_servicios WHERE id_servicio = ?1")
    void DeleteEventoServicios(int idServicio);
}
