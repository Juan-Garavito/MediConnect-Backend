package com.uis.MediConnect.Service;


import com.uis.MediConnect.Model.OrdenTratamiento;

import java.util.List;

public interface IOrdenTratamiento {

    OrdenTratamiento guardarOrdenTratamiento(OrdenTratamiento orden);
    OrdenTratamiento buscarOrdenTratamiento(String idOrden);
    List<OrdenTratamiento> buscarTodasOrdenTratamiento();
    OrdenTratamiento editarOrdenTratamiento(OrdenTratamiento orden);
    OrdenTratamiento eliminarOrdenTratamiento(String idOrden);
}
