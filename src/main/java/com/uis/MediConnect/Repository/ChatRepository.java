package com.uis.MediConnect.Repository;

import com.uis.MediConnect.Model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,String> {

    Chat findByIdCita(String idCita);
}
