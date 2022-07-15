package com.example.TrabajoIntegrador.Services;

import com.example.TrabajoIntegrador.Entity.Odontologo;
import com.example.TrabajoIntegrador.Repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {

    @Autowired
    IOdontologoRepository odontologoRepository;

    public OdontologoService() {
    }

    public Odontologo guardar(Odontologo o){
        return odontologoRepository.save(o);
    }

    public Odontologo buscar(Integer id){
        return odontologoRepository.findById(id).get();
    }

    public List<Odontologo> buscarTodos(){
        return odontologoRepository.findAll();
    }

    public void eliminar(int id){
        odontologoRepository.deleteById(id);
    }

//    public Odontologo actualizar(Odontologo o){
//        return odontologoRepository.(o);
//    }
}
