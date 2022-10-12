package eventos.eventos.Services.tipoServicio;

import eventos.eventos.Model.TipoServicio;

public interface TipoServicioService {

    TipoServicio findTipoServicio(int idTipoServicio) throws Exception;

    TipoServicio saveTipoServicio(TipoServicio tipoServicio) throws Exception;
}
