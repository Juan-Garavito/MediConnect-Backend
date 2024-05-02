package com.uis.MediConnect.Service;

import com.uis.MediConnect.Model.OrdenTratamiento;
import com.uis.MediConnect.Repository.OrdenTratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdenTratamientoService implements IOrdenTratamientoService {

    private final OrdenTratamientoRepository ordenTratamientoRepository;

    @Autowired
    public OrdenTratamientoService(OrdenTratamientoRepository ordenTratamientoRepository) {
        this.ordenTratamientoRepository = ordenTratamientoRepository;
    }

    @Override
    public OrdenTratamiento guardarOrdenTratamiento(OrdenTratamiento orden) {
        return ordenTratamientoRepository.save(orden);
    }

    @Override
    public OrdenTratamiento buscarOrdenTratamiento(String idOrden) {
        return ordenTratamientoRepository.findById(idOrden).orElse(null);
    }

    @Override
    public List<OrdenTratamiento> buscarTodasOrdenTratamiento() {
        return ordenTratamientoRepository.findAll();
    }

    @Override
    public OrdenTratamiento editarOrdenTratamiento(OrdenTratamiento orden) {
        OrdenTratamiento ordenTratamiento = buscarOrdenTratamiento(orden.getIdOrdenTratamineto());
        if(ordenTratamiento != null){
            guardarOrdenTratamiento(orden);
            return orden;
        }
        return null;
    }

    @Override
    public OrdenTratamiento eliminarOrdenTratamiento(String idOrden) {
        OrdenTratamiento ordenTratamiento = buscarOrdenTratamiento(idOrden);
        if (ordenTratamiento != null){
            ordenTratamientoRepository.delete(ordenTratamiento);
            return ordenTratamiento;
        }
        return null;
    }
}
