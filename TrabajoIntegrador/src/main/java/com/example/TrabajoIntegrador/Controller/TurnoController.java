package com.example.TrabajoIntegrador.Controller;

import com.example.TrabajoIntegrador.Entity.Odontologo;
import com.example.TrabajoIntegrador.Entity.Paciente;
import com.example.TrabajoIntegrador.Entity.Turno;
import com.example.TrabajoIntegrador.Services.OdontologoService;
import com.example.TrabajoIntegrador.Services.PacienteService;
import com.example.TrabajoIntegrador.Services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoService turnoService;
    @Autowired
    PacienteService pacienteService;
    @Autowired
    OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno) {

        ResponseEntity<Turno> response;
        Paciente p =pacienteService.buscar(turno.getPaciente().getId());
        Odontologo o = odontologoService.buscar(turno.getOdontologo().getId());

        if (p != null && o != null) {
            response = ResponseEntity.ok(turnoService.guardar(turno));
        }
        else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos() {
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public Turno buscar(@PathVariable("id") Integer identificador) {
        return turnoService.buscar(identificador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response;
        if (turnoService.buscar(id) != null) {
            turnoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

//    @PutMapping
//    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) {
//        return ResponseEntity.ok(turnoService.actualizar(turno));
//
//    }

}
