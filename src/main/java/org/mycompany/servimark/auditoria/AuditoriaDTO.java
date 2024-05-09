package org.mycompany.servimark.auditoria;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record AuditoriaDTO(
    Long id,
    @NotBlank(message = "La descripción no puede estar vacia") 
    String descripcion,
    LocalDate fecha) {
        public AuditoriaDTO(Long id, String descripcion, LocalDate fecha) {
            this.id = id;
            this.descripcion = descripcion;
            this.fecha = LocalDate.now();
        }
    
}
