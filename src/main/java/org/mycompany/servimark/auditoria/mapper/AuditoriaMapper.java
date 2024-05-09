package org.mycompany.servimark.auditoria.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mycompany.servimark.auditoria.AuditoriaDTO;
import org.mycompany.servimark.auditoria.model.Auditoria;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuditoriaMapper {
    Auditoria auditoriaDTOtoAuditoria(AuditoriaDTO auditoriaDTO);
    AuditoriaDTO auditoriaToAuditoriaDTO(Auditoria auditoria);
}
