package org.mycompany.servimark.service.mapper;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.mycompany.servimark.core.models.Municipality;
import org.mycompany.servimark.service.ServiceDTO;
import org.mycompany.servimark.service.model.Category;
import org.mycompany.servimark.service.model.Service;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T20:14:30-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public Service serviceDTOToService(ServiceDTO serviceDTO) {
        if ( serviceDTO == null ) {
            return null;
        }

        Service service = new Service();

        service.setCategory( serviceDTO.category() );
        service.setDescription( serviceDTO.description() );
        service.setId( serviceDTO.id() );
        service.setMunicipality( serviceDTO.municipality() );
        service.setName( serviceDTO.name() );
        service.setPrice( serviceDTO.price() );

        return service;
    }

    @Override
    public ServiceDTO serviceToServiceDTO(Service service) {
        if ( service == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String description = null;
        BigDecimal price = null;
        Category category = null;
        Municipality municipality = null;

        id = service.getId();
        name = service.getName();
        description = service.getDescription();
        price = service.getPrice();
        category = service.getCategory();
        municipality = service.getMunicipality();

        ServiceDTO serviceDTO = new ServiceDTO( id, name, description, price, category, municipality );

        return serviceDTO;
    }
}
