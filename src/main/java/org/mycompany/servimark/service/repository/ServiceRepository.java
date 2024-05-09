package org.mycompany.servimark.service.repository;

import org.mycompany.servimark.service.ServiceDTO;
import org.mycompany.servimark.service.dto.HistoryServiceDTO;
import org.mycompany.servimark.service.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, String> {
    @Query("""
        SELECT new org.mycompany.servimark.service.dto.HistoryServiceDTO(s.id, s.name, s.description, s.price) 
        FROM Service s
        JOIN s.userService us
        JOIN us.user u
        WHERE u.id = :userId
        """)
    List<HistoryServiceDTO> findByUserId(@Param("userId") String userId);
}