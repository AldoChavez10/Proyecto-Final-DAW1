package com.rest01.modelo;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_membresia")
public class Membresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @OneToMany(mappedBy = "membresia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Inscripcion> inscripciones;

    // Constructor vacío
    public Membresia() {
    }

    // Constructor con todos los atributos
    public Membresia(int id, String tipo, double precio, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Set<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
}
