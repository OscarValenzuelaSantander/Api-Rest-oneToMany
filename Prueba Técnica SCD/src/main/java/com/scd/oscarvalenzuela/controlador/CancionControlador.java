package com.scd.oscarvalenzuela.controlador;

import com.scd.oscarvalenzuela.excepcion.CancionNoEncontradaExcepcion;
import com.scd.oscarvalenzuela.modelo.Cancion;
import com.scd.oscarvalenzuela.servicio.CancionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("scd-app")
@CrossOrigin(value = "http://localhost:4200")
public class CancionControlador {

    @Autowired
    private CancionServicio cancionServicio;

    @GetMapping("/listar/canciones")
    public List<Cancion> obtenerCancion(){
        List<Cancion> canciones = this.cancionServicio.listarCancion();
        return canciones;
    }

    @PostMapping("/agregar/cancion")
    public Cancion agregarCancion(@RequestBody Cancion cancion){
        return this.cancionServicio.guardarCancion(cancion);
    }

    @GetMapping("/buscar/cancion/{id}")
    public ResponseEntity<Cancion> obtenerCancionPorId(@PathVariable long id){
        Cancion cancion = this.cancionServicio.buscarCancionPorId(id);
        if(cancion != null)
            return ResponseEntity.ok(cancion);
        else throw new CancionNoEncontradaExcepcion("No se encontro el id: " + id);
    }

    @PutMapping("/editar/cancion/{id}")
    public ResponseEntity<Cancion> actualizarCancione(@PathVariable long id, @RequestBody Cancion cancionRecibida){
        Cancion cancion = this.cancionServicio.buscarCancionPorId(id);
        if(cancion == null) throw new CancionNoEncontradaExcepcion("No se encontro el id: " + id);
        cancion.setTitulo(cancionRecibida.getTitulo());
        cancion.setFechaCreacion(cancionRecibida.getFechaCreacion());
        cancion.setEstadoInscripcion(cancionRecibida.isEstadoInscripcion());
        cancion.setPrecioInscripcionClp(cancionRecibida.getPrecioInscripcionClp());
        cancion.setPrecioInscripcionUsd(cancionRecibida.getPrecioInscripcionUsd());
        this.cancionServicio.guardarCancion(cancion);
        return ResponseEntity.ok(cancion);
    }

    @DeleteMapping("/eliminar/cancion/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCancion(@PathVariable long id){
        Cancion cancion = cancionServicio.buscarCancionPorId(id);
        if(cancion == null) throw new CancionNoEncontradaExcepcion("No se encontro el id: " + id);
        this.cancionServicio.eliminarCancionPorId(cancion.getIdCancion());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
