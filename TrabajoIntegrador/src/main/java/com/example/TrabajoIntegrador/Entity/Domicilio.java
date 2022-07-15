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
public class Domicilio {
    @Id
    @SequenceGenerator(name = "domicilioSequence",sequenceName = "domicilioSequence")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "domicilioSequence")
    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    //Constructor de odontologo sin el id
    public Domicilio(Integer id, String calle, String numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    //Constructor de odontologo con el id
    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    //Constructor de odontologo default
    public Domicilio() {}

}
