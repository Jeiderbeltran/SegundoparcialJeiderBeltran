package org.mycompany.servimark.user.repository;

import org.mycompany.servimark.user.dto.UserDTO;
import org.mycompany.servimark.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepositoty extends JpaRepository<User, String> {
}
