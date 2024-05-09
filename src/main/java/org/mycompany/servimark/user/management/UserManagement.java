package org.mycompany.servimark.user.management;

import org.mycompany.servimark.user.UserExternalAPI;
import org.mycompany.servimark.user.UserInternalAPI;
import org.mycompany.servimark.user.dto.UserDTO;
import org.mycompany.servimark.user.mapper.UserMapper;
import org.mycompany.servimark.user.repository.UserRepositoty;
import org.springframework.stereotype.Service;

@Service
public class UserManagement implements UserInternalAPI, UserExternalAPI {

    private final UserRepositoty userRepositoty;
    private final UserMapper userMapper;

    public UserManagement(UserRepositoty userRepositoty, UserMapper userMapper) {
        this.userRepositoty = userRepositoty;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUserById(String userId) {
        return userMapper.userToUserDTO(userRepositoty.findById(userId).get());
    }
}
