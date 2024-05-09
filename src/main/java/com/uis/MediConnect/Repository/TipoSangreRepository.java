package com.uis.MediConnect.Repository;


import com.uis.MediConnect.Model.TipoSangre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSangreRepository extends JpaRepository<TipoSangre, Integer> {
}
