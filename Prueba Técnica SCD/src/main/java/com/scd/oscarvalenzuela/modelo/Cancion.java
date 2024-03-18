package com.scd.oscarvalenzuela.modelo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Table(name="canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cancion")
    private Long idCancion;
    @Column(length = 200)
    private String titulo;
    @Column(name="fecha_creacion", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaCreacion;
    @Column(name="estado_inscripcion")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private boolean estadoInscripcion;
    @Column(name="precio_inscripcion_clp")
    private Integer precioInscripcionClp;
    @Column(name="precio_inscripcion_usd")
    private Double precioInscripcionUsd;

    public Cancion() {}

    public Cancion(long idCancion){
        this.idCancion = idCancion;
    }

    public Cancion(String titulo, LocalDate fechaCreacion, boolean estadoInscripcion, Integer precioInscripcionClp, Double precioInscripcionUsd) {
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.estadoInscripcion = estadoInscripcion;
        this.precioInscripcionClp = precioInscripcionClp;
        this.precioInscripcionUsd = precioInscripcionUsd;
    }

    public Cancion(long idCancion, String titulo, LocalDate fechaCreacion, boolean estadoInscripcion, Integer precioInscripcionClp, Double precioInscripcionUsd, Compositor compositor) {
        this.idCancion = idCancion;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.estadoInscripcion = estadoInscripcion;
        this.precioInscripcionClp = precioInscripcionClp;
        this.precioInscripcionUsd = precioInscripcionUsd;
    }

    public Long getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Long idCancion) {
        this.idCancion = idCancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEstadoInscripcion() {
        return estadoInscripcion;
    }

    public void setEstadoInscripcion(boolean estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }

    public Integer getPrecioInscripcionClp() {
        return precioInscripcionClp;
    }

    public void setPrecioInscripcionClp(Integer precioInscripcionClp) {
        this.precioInscripcionClp = precioInscripcionClp;
    }

    public Double getPrecioInscripcionUsd() {
        return precioInscripcionUsd;
    }

    public void setPrecioInscripcionUsd(Double precioInscripcionUsd) {
        this.precioInscripcionUsd = precioInscripcionUsd;
    }
}

