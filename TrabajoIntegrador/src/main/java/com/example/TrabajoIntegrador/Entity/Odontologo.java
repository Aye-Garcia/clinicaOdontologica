package com.example.TrabajoIntegrador.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table
public class Odontologo {
    @Id
    @SequenceGenerator(name = "odontologoSequence",sequenceName = "odontologoSequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologoSequence")
    private Integer id;
    private String apellido;
    private String nombre;
    private String matricula;

    //Constructor de odontologo sin el id
    public Odontologo(String nombre, String apellido, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    //Constructor de odontologo con el id
    public Odontologo(Integer id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    //Constructor de odontologo default
    public Odontologo() {}
}
