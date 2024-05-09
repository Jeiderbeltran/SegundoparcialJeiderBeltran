package org.mycompany.servimark.service.management;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.mycompany.servimark.service.ServiceDTO;
import org.mycompany.servimark.service.ServiceExternalAPI;
import org.mycompany.servimark.service.ServiceInternalAPI;
import org.mycompany.servimark.service.dto.HistoryServiceDTO;
import org.mycompany.servimark.service.mapper.ServiceMapper;
import org.mycompany.servimark.service.model.UserService;
import org.mycompany.servimark.service.repository.ServiceRepository;
import org.mycompany.servimark.service.repository.UserServiceRepository;
import org.mycompany.servimark.user.UserInternalAPI;
import org.mycompany.servimark.user.dto.UserDTO;
import org.mycompany.servimark.user.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ServiceManagement implements ServiceInternalAPI, ServiceExternalAPI {

    private final ServiceRepository serviceRepository;
    private final UserServiceRepository userServiceRepository;
    private final ServiceMapper serviceMapper;
    private final UserInternalAPI userInternalAPI;

    public ServiceManagement(ServiceRepository serviceRepository, ServiceMapper serviceMapper, UserServiceRepository userServiceRepository, UserInternalAPI userInternalAPI) {
        this.serviceMapper = serviceMapper;
        this.serviceRepository = serviceRepository;
        this.userServiceRepository = userServiceRepository;
        this.userInternalAPI = userInternalAPI;
    }

    public ResponseEntity<Map<String, Object>> getServices() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("data", serviceRepository.findAll());
        map.put("status", "true");
        map.put("message", "Servicios obtenidos exitosamente");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<Map<String,Object>> saveService(ServiceDTO serviceDTO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        UUID serviceId = UUID.randomUUID();
        //Create entity service
        org.mycompany.servimark.service.model.Service service = serviceMapper.serviceDTOToService(serviceDTO);
        service.setId(serviceId.toString());
        //Save entity service
        ServiceDTO save = serviceMapper.serviceToServiceDTO(serviceRepository.save(service));
        //Create entity user_service
        User user = serviceDTO.user();
        UserService userService = new UserService();
        userService.setService(service);
        userService.setUser(user);
        //Save entity user_service
        userServiceRepository.save(userService);
        //Response
        map.put("data", save);
        map.put("status", "true");
        map.put("message", "Servicio guardado exitosamente");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
        public ResponseEntity<Map<String, Object>> getHistoryServiceByUser(UserDTO userDTO) {
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            try {
            List<HistoryServiceDTO> historyServiceDTO = serviceRepository.findByUserId(userDTO.id());
            for (HistoryServiceDTO hsDTO : historyServiceDTO) {
            }
            map.put("data", historyServiceDTO);
            map.put("status", "true");
            map.put("message", "Historial de servicios obtenido exitosamente");
            return new ResponseEntity<>(map, HttpStatus.OK);
    } catch (Exception e) {
        contErrors++;
        if(contErrors >= 3){
            AuditoriaDTO auditoria = new AuditoriaDTO(null, e.getMessage(), null);
            try {
                auditoriaInternalAPI.createAuditoria(auditoria);
            } catch (Exception ex) {
                auditoriaInternalAPI.createAuditoriaToTxt(auditoria);
            }
        }
    }
    map.put("status", "false");
    map.put("message", "Error al guardar el servicio");
    return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    }




    
