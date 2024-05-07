package org.mycompany.servimark.user.management;

import org.mycompany.servimark.user.UserExternalAPI;
import org.mycompany.servimark.user.UserInternalAPI;
import org.springframework.stereotype.Service;

@Service
public class UserManagement implements UserInternalAPI, UserExternalAPI {
}
