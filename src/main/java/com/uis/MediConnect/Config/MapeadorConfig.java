package com.uis.MediConnect.Config;

import com.uis.MediConnect.Config.Mapeador.MapeadorCita;
import com.uis.MediConnect.Repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapeadorConfig {

    private final FranjaHorariaRepository franjaHorariaRepository;
    private final EspecialidadRepository especialidadRepository;
    private final IpsRepository ipsRepository;
    private final ModalidadCitaRepository modalidadCitaRepository;
    private final CiudadanoRepository ciudadanoRepository;
    private final ChatRepository chatRepository;

    public MapeadorConfig(FranjaHorariaRepository franjaHorariaRepository, EspecialidadRepository especialidadRepository, IpsRepository ipsRepository, ModalidadCitaRepository modalidadCitaRepository, CiudadanoRepository ciudadanoRepository, ChatRepository chatRepository) {
        this.franjaHorariaRepository = franjaHorariaRepository;
        this.especialidadRepository = especialidadRepository;
        this.ipsRepository = ipsRepository;
        this.modalidadCitaRepository = modalidadCitaRepository;
        this.ciudadanoRepository = ciudadanoRepository;
        this.chatRepository = chatRepository;
    }

    @Bean
    public MapeadorCita mapearCitaACitaDTO(){
        return new MapeadorCita(franjaHorariaRepository,
                especialidadRepository,
                ipsRepository,
                modalidadCitaRepository,
                ciudadanoRepository,
                chatRepository);
    }
}
