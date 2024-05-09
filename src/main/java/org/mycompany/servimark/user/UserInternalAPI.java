package org.mycompany.servimark.user;

import org.mycompany.servimark.user.dto.UserDTO;

public interface UserInternalAPI {
    UserDTO getUserById(String userId);
}
