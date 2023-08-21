package com.app.User.domain.ports.in;

import com.app.User.domain.models.AdicionalTarea;

public interface GetAdicionalTareaUserCase {

    AdicionalTarea getAdicionalTarea(Integer id);
}
