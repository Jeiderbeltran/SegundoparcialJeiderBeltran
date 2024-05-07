package org.mycompany.servimark.service;

import java.math.BigDecimal;

import org.mycompany.servimark.core.models.Municipality;
import org.mycompany.servimark.service.model.Category;

import jakarta.validation.constraints.NotBlank;


public record ServiceDTO(
    String id,
    @NotBlank(message = "El nombre del servicio no puede estar vacio ")
    String name,
    @NotBlank(message = "La descripcion no puede estar vacia")
    String description,
    @NotBlank (message = "El precio no puede estar vacio")
    BigDecimal price, 
    @NotBlank (message = "La categoria no puede estar vacia")
    Category category, 
    @NotBlank(message = "El municipio no debe estar vacio")
    Municipality municipality ) {

    public ServiceDTO (String id, String name,String description, BigDecimal price, Category category, Municipality municipality) {
    this.id=id;
    this.name=name;
    this.description=description;
    this.price=price;
    this.category=category;
    this.municipality=municipality;
    }
}

