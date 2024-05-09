package org.mycompany.servimark.auditoria.management;

import java.io.FileWriter;
import java.io.IOException;

import org.mycompany.servimark.auditoria.AuditoriaDTO;
import org.mycompany.servimark.auditoria.AuditoriaExternalAPI;
import org.mycompany.servimark.auditoria.AuditoriaInternalAPI;
import org.mycompany.servimark.auditoria.mapper.AuditoriaMapper;
import org.mycompany.servimark.auditoria.model.Auditoria;
import org.mycompany.servimark.auditoria.repository.AuditoriaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AunditoriaManagement implements AuditoriaExternalAPI, AuditoriaInternalAPI {

    private final AuditoriaRepository auditoriaRepository;
    private final AuditoriaMapper auditoriaMapper;

    public AunditoriaManagement(AuditoriaRepository auditoriaRepository, AuditoriaMapper auditoriaMapper) {
        this.auditoriaMapper = auditoriaMapper;
        this.auditoriaRepository = auditoriaRepository;
    }
    
    @Override
    public AuditoriaDTO createAuditoria(AuditoriaDTO auditoriaDTO) {
        try {
            Auditoria auditoria = auditoriaMapper.auditoriaDTOtoAuditoria(auditoriaDTO);
            return auditoriaMapper.auditoriaToAuditoriaDTO(auditoriaRepository.save(auditoria));
        } catch (DataAccessException e) {
            throw e;
        }
    }

    @Override
    public void createAuditoriaToTxt(AuditoriaDTO auditoria) {
        try (FileWriter writer = new FileWriter("auditoria.txt", true)) {
            writer.write("Fecha: " + auditoria.fecha() + ", Descripción: " + auditoria.descripcion() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
