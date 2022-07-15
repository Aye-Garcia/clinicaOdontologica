package com.example.TrabajoIntegrador.Services;

import com.example.TrabajoIntegrador.Entity.Domicilio;
import com.example.TrabajoIntegrador.Entity.Paciente;
import com.example.TrabajoIntegrador.Repository.IDomicilioRepository;
import com.example.TrabajoIntegrador.Repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;
    @Autowired
    IDomicilioRepository domicilioRepository;

    public PacienteService() {}

    public Paciente guardar(Paciente p){
        Domicilio d = domicilioRepository.save(p.getDomicilio());
        p.setDomicilio(d);
        return pacienteRepository.save(p);
    }

    public Paciente buscar(int id){
        return pacienteRepository.findById(id).get();
    }

    public List<Paciente> buscarTodos(){
        return pacienteRepository.findAll();
    }

    public void eliminar(int id){
        pacienteRepository.deleteById(id);
    }

//    public Paciente actualizar(Paciente p){
//        return pacienteRepository.actualizar(p);
//    }
}
