package org.mycompany.servimark.auditoria.repository;

import org.mycompany.servimark.auditoria.model.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriaRepository extends JpaRepository<Auditoria, String> {
}
