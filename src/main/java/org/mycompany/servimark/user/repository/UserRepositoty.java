package org.mycompany.servimark.user.repository;

import org.mycompany.servimark.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<User, String> {
}
