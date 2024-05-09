package org.mycompany.servimark.auditoria;

import org.mycompany.servimark.auditoria.model.Auditoria;

public interface AuditoriaInternalAPI {
    AuditoriaDTO createAuditoria(AuditoriaDTO auditoria);
    void createAuditoriaToTxt(AuditoriaDTO auditoria);
}
