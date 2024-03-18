package com.scd.oscarvalenzuela.modelo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="compositores")
public class Compositor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compositor")
    private Long idCompositor;
    @Column(length = 200)
    private String nombre;
    @Column(columnDefinition = "DATE")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;
    @Column(name="solicitud_inscripcion")
    private boolean solicitudInscripcion;
    private Integer celular;
    @Column(name="precio_inscripcion")
    private double precioInscripcion;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cancion> cancion = new ArrayList<>();

    public Compositor() {}

    public Compositor(long idCompositor){
        this.idCompositor = idCompositor;
    }

    public Compositor(String nombre, LocalDate fecha, boolean solicitudInscripcion, Integer celular, double precioInscripcion, List<Cancion> cancion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.solicitudInscripcion = solicitudInscripcion;
        this.celular = celular;
        this.precioInscripcion = precioInscripcion;
        this.cancion = cancion;
    }

    public Compositor(long idCompositor, String nombre, LocalDate fecha, boolean solicitudInscripcion, int celular, double precioInscripcion, List<Cancion> cancion) {
        this.idCompositor = idCompositor;
        this.nombre = nombre;
        this.fecha = fecha;
        this.solicitudInscripcion = solicitudInscripcion;
        this.celular = celular;
        this.precioInscripcion = precioInscripcion;
        this.cancion = cancion;
    }

    public Long getIdCompositor() {
        return idCompositor;
    }

    public void setIdCompositor(Long idCompositor) {
        this.idCompositor = idCompositor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isSolicitudInscripcion() {
        return solicitudInscripcion;
    }

    public void setSolicitudInscripcion(boolean solicitudInscripcion) {
        this.solicitudInscripcion = solicitudInscripcion;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public double getPrecioInscripcion() {
        return precioInscripcion;
    }

    public void setPrecioInscripcion(double precioInscripcion) {
        this.precioInscripcion = precioInscripcion;
    }

    public List<Cancion> getCancion() {
        return cancion;
    }

    public void setCancion(List<Cancion> cancion) {
        this.cancion = cancion;
    }
}

