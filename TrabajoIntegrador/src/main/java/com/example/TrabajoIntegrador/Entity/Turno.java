package com.example.TrabajoIntegrador.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Setter
@Entity
@Table
public class Turno {
    @Id
    @SequenceGenerator(name = "turnoSequence",sequenceName = "turnoSequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turnoSequence")
    private Integer id;
    private Date fecha;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id",referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Paciente paciente;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id",referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Odontologo odontologo;

    //Constructor de odontologo con el id
    public Turno(int id, Paciente paciente, Odontologo odontologo, Date fecha ) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    //Constructor de odontologo sin el id
    public Turno(Paciente paciente, Odontologo odontologo, Date fecha) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }
}
