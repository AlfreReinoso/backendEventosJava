package eventos.eventos.Web.servicio;

import eventos.eventos.Model.Servicio;

import java.util.List;

public interface ServicioController {

    Servicio saveTipoServicio(Servicio servicio) throws Exception;

    Servicio updateTipoServicio(Servicio servicio) throws Exception;

    Servicio findServicio(int idServicio) throws Exception;

    List<Servicio> findAll() throws Exception;

    void deleteServicio(Servicio servicio) throws Exception;
}
