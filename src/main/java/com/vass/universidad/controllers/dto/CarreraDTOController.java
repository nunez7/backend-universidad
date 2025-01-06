package com.vass.universidad.controllers.dto;

import com.vass.universidad.models.dto.CarreraDTO;
import com.vass.universidad.models.entities.Carrera;
import com.vass.universidad.models.mappers.mapstruct.CarreraMapperMS;
import com.vass.universidad.services.contract.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class CarreraDTOController extends GenericDTOController<Carrera, CarreraService>{

    @Autowired
    private CarreraMapperMS mapper;

    public CarreraDTOController(CarreraService service) {
        super(service, "Carrera");
    }

    @GetMapping
    public ResponseEntity<?> obtenerCarreras(){
        Map<String, Object> mensaje = new HashMap<>();
        List<Carrera> carreras = super.obtenerTodos();

        if(carreras.isEmpty()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", "No se econtraron carreras cargadas");
            return ResponseEntity.badRequest().body(mensaje);
        }
        List<CarreraDTO> carrerasDTOS = carreras.stream()
                .map(mapper::mapCarrera)
                .toList();

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", carrerasDTOS);

        return ResponseEntity.ok(mensaje);
    }

}
