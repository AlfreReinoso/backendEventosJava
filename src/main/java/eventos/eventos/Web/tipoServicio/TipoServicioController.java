package eventos.eventos.Web.tipoServicio;

import eventos.eventos.Model.TipoServicio;

public interface TipoServicioController {

    TipoServicio findTipoServicio(int idTipoServicio) throws Exception;

    TipoServicio saveTipoServicio(TipoServicio tipoServicio) throws Exception;
}
