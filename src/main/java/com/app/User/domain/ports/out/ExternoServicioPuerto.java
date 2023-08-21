package com.app.User.domain.ports.out;

import com.app.User.domain.models.AdicionalTarea;

public interface ExternoServicioPuerto {

    AdicionalTarea getAdicionalTarea(Integer tareaId);


}
