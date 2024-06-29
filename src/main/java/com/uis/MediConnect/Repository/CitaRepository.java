package com.uis.MediConnect.Repository;

import com.uis.MediConnect.Model.Cita;
import net.sf.jsqlparser.statement.select.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, String> {

    List<Cita> findAllByIdPaciente(String idpaciente);
    //Método para obtener las citas asociadas a un médico
    public List<Cita> findALLByIdMedico(String idmedico);
    List<Cita> findAllByIdPacienteOrderByFechaCita(String idpaciente);

    @Query(nativeQuery = true, value = "select * from cita where idpaciente = :idpaciente and fechacita >= :fechaahora order by fechacita")
    List<Cita> findAllByIdPacienteOrderByFechaCitaAhora(@Param("idpaciente") String idpaciente, @Param("fechaahora") LocalDate fechaahora);

    @Query( nativeQuery = true, value = "select * from cita where idpaciente = :idpaciente and fechacita >= :fechaahora order by fechacita limit :maxLimit")
    List<Cita> findAllByIdPacienteOrderByFechaCitaConLimiteAHora(@Param("idpaciente") String idpaciente, @Param("maxLimit") int maxLimit,  @Param("fechaahora") LocalDate fechaahora);

}
