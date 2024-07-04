package com.rest01.modelo;

import jakarta.persistence.*;
import java.time.LocalDate; // Importa la clase LocalDate

@Entity
@Table(name = "tbl_inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_membresia", nullable = false)
    private Membresia membresia;

    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDate fechaInscripcion;
 // Cambia el tipo de dato a LocalDate

    // Constructor vacío
    public Inscripcion() {
    }

    // Constructor con todos los atributos
    public Inscripcion(int id, Cliente cliente, Membresia membresia, LocalDate fechaInscripcion) {
        this.id = id;
        this.cliente = cliente;
        this.membresia = membresia;
        this.fechaInscripcion = fechaInscripcion;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
