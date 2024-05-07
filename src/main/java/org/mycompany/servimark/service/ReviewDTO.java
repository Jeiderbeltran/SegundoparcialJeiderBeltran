package org.mycompany.servimark.service;

import java.math.BigDecimal;

import org.mapstruct.control.MappingControl.Use;
import org.mycompany.servimark.user.model.User;

import jakarta.validation.constraints.NotBlank;

import org.mycompany.servimark.service.model.Service;;

public record ReviewDTO(
    long id,
    @NotBlank (message = "El usuario no debe estar vacio")
    User user,
    Service service,
    BigDecimal rating,
    String comment ) {

    public ReviewDTO() {
        
    }
}
