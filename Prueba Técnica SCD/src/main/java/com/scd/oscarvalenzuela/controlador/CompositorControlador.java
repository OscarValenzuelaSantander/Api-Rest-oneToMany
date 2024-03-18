package com.scd.oscarvalenzuela.controlador;

import com.scd.oscarvalenzuela.excepcion.CancionNoEncontradaExcepcion;
import com.scd.oscarvalenzuela.excepcion.CompositorNoEncontradoExcepcion;
import com.scd.oscarvalenzuela.modelo.Cancion;
import com.scd.oscarvalenzuela.modelo.Compositor;
import com.scd.oscarvalenzuela.servicio.CancionServicio;
import com.scd.oscarvalenzuela.servicio.CompositorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("scd-app")
@CrossOrigin(value = "http://localhost:4200")
public class CompositorControlador {

    @Autowired
    private CompositorServicio compositorServicio;

    @GetMapping("/listar/compositores")
    public List<Compositor> obtenerCompositor(){
        List<Compositor> compositores = this.compositorServicio.listarCompositor();
        //logger.info("Canciones obtenidas:");
        //canciones.forEach((cancion -> logger.info(cancion.toString())));
        return compositores;
    }

    @PostMapping("/agregar/compositor")
    public Compositor agregarCompositor(@RequestBody Compositor compositor){
        return this.compositorServicio.guardarCompositor(compositor);
    }

    @GetMapping("/buscar/compositor/{id}")
    public ResponseEntity<Compositor> obtenerCompositorPorId(@PathVariable long id){
        Compositor compositor = this.compositorServicio.buscarCompositorPorId(id);
        if(compositor != null)
            return ResponseEntity.ok(compositor);
        else throw new CancionNoEncontradaExcepcion("No se encontro el id: " + id);
    }

    @PutMapping("/editar/compositor/{id}")
    public ResponseEntity<Compositor> actualizarCompositor(@PathVariable long id,
                                                      @RequestBody Compositor compositorRecibido){
        Compositor compositor = this.compositorServicio.buscarCompositorPorId(id);
        if(compositor == null) throw new CompositorNoEncontradoExcepcion("No se encontro el id: " + id);
        compositor.setCelular(compositorRecibido.getCelular());
        compositor.setFecha(compositorRecibido.getFecha());
        compositor.setNombre(compositorRecibido.getNombre());
        compositor.setPrecioInscripcion(compositorRecibido.getPrecioInscripcion());
        compositor.setSolicitudInscripcion(compositorRecibido.isSolicitudInscripcion());
        compositor.setCancion(compositorRecibido.getCancion());
        this.compositorServicio.guardarCompositor(compositor);
        return ResponseEntity.ok(compositor);
    }

    @DeleteMapping("/eliminar/compositor/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCompositor(@PathVariable long id){
        Compositor compositor = compositorServicio.buscarCompositorPorId(id);
        if(compositor == null) throw new CompositorNoEncontradoExcepcion("No se encontro el id: " + id);
        this.compositorServicio.eliminarCompositorPorId(compositor.getIdCompositor());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
