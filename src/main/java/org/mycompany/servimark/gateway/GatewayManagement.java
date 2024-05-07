package org.mycompany.servimark.gateway;

import org.mycompany.servimark.core.CoreExternalAPI;
import org.mycompany.servimark.core.dto.DepartamentDTO;
import org.mycompany.servimark.order.OrderExternalAPI;
import org.mycompany.servimark.service.ServiceExternalAPI;
import org.mycompany.servimark.user.UserExternalAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class GatewayManagement {
    private CoreExternalAPI coreExternalAPI;
    private OrderExternalAPI orderExternalAPI;
    private UserExternalAPI userExternalAPI;
    private ServiceExternalAPI serviceExternalAPI;

    public GatewayManagement(OrderExternalAPI orderExternalAPI,
                             CoreExternalAPI coreExternalAPI,
                             UserExternalAPI userExternalAPI,
                             ServiceExternalAPI serviceExternalAPI) {
        this.orderExternalAPI = orderExternalAPI;
        this.coreExternalAPI = coreExternalAPI;
        this.userExternalAPI = userExternalAPI;
        this.serviceExternalAPI = serviceExternalAPI;
    }

    @PostMapping("/departament")
    public ResponseEntity<?> saveDepartament(@Valid @RequestBody DepartamentDTO departamentDTO) {
        return coreExternalAPI.saveDepartament(departamentDTO);
    }
}
