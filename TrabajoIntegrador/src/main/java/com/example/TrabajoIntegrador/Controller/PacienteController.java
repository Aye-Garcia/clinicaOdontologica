package com.example.TrabajoIntegrador.Controller;

import com.example.TrabajoIntegrador.Entity.Paciente;
import com.example.TrabajoIntegrador.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardar(paciente));

    }

    @GetMapping()
    public ResponseEntity<List<Paciente>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(pacienteService.buscar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (pacienteService.buscar(id) != null) {
            pacienteService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

//    @PutMapping()
//    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
//        ResponseEntity<Paciente> response = null;
//
//        if (paciente.getId() != null && pacienteService.buscar(paciente.getId()) != null)
//            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
//        else
//            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//        return response;
//    }
}
