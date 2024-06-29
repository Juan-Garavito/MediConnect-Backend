package com.uis.MediConnect.Repository;

import com.uis.MediConnect.Model.Mensaje;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, String> {
    List<Mensaje> findAllByIdChatOrderByFechaMensajeDesc(String idChat, Pageable pageable);

    List<Mensaje> findAllByIdChat(String idChat);
}
