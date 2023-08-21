package com.app.User.infrastructure.config;

import com.app.User.aplication.services.TareaServicio;
import com.app.User.aplication.usecases.*;
import com.app.User.domain.ports.in.GetAdicionalTareaUserCase;
import com.app.User.domain.ports.out.ExternoServicioPuerto;
import com.app.User.domain.ports.out.TareaRepositorioPuerto;
import com.app.User.infrastructure.adapters.ExternalServiceAdapter;
import com.app.User.infrastructure.repositories.TareaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicacionConfig {

    @Bean
    public TareaServicio tareaServicio(TareaRepositorioPuerto tareaRepositorioPuerto, GetAdicionalTareaUserCase getAdicionalTareaUserCase){
        return new TareaServicio(
                new CrearTareaUserCaseImpl(tareaRepositorioPuerto),
                new ActualizarTareaUserCaseImpl(tareaRepositorioPuerto),
                new EliminarTareaUserCaseImpl(tareaRepositorioPuerto),
                new RecuperarTareaUserCaseImpl(tareaRepositorioPuerto),
                getAdicionalTareaUserCase
                );
    }

    @Bean
    public TareaRepositorioPuerto tareaRepositorioPuerto(TareaRepositoryAdapter tareaRepositoryAdapter){
        return tareaRepositoryAdapter;
    }

    @Bean
    public GetAdicionalTareaUserCase getAdicionalTareaUserCase(ExternoServicioPuerto externoServicioPuerto){
        return new GetAdicionalTareaUserCaseImpl(externoServicioPuerto);
    }

    @Bean
    public ExternoServicioPuerto externoServicioPuerto(){
        return new ExternalServiceAdapter();

    }




}
