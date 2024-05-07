package org.mycompany.servimark.service.repository;

import org.mycompany.servimark.service.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, String> {
    @Query("SELECT s FROM Service s WHERE s.name = :name")
    List<Service> findByName(@Param("name") String name);

    @Query("SELECT s FROM Service s WHERE s.name LIKE %:text%")
    List<Service> findByNameContaining(@Param("text") String text);

    @Query("SELECT s FROM Service s WHERE s.serviceStatus = :isActive")
    List<Service> findByIsActive(@Param("isActive") Boolean isActive);
}