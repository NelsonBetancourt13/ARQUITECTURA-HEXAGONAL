package com.app.User.aplication.usecases;

import com.app.User.domain.models.AdicionalTarea;
import com.app.User.domain.ports.in.GetAdicionalTareaUserCase;
import com.app.User.domain.ports.out.ExternoServicioPuerto;

public class GetAdicionalTareaUserCaseImpl implements GetAdicionalTareaUserCase {


    public final ExternoServicioPuerto externoServicioPuerto;


    public GetAdicionalTareaUserCaseImpl(ExternoServicioPuerto externoServicioPuerto) {
        this.externoServicioPuerto = externoServicioPuerto;
    }

    @Override
    public AdicionalTarea getAdicionalTarea(Integer id) {
        return externoServicioPuerto.getAdicionalTarea(id);
    }
}
