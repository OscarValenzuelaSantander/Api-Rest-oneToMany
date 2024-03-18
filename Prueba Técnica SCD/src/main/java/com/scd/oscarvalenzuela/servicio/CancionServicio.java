package com.scd.oscarvalenzuela.servicio;

import com.scd.oscarvalenzuela.modelo.Cancion;
import com.scd.oscarvalenzuela.repositorio.CancionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancionServicio implements ICancionServicio{

    @Autowired
    private CancionRepositorio cancionRepositorio;

    @Override
    public List<Cancion> listarCancion() {
       return this.cancionRepositorio.findAll();
    }

    @Override
    public Cancion buscarCancionPorId(Long idCancion) {
        Cancion cancion = this.cancionRepositorio.findById(idCancion).orElse(null);
        return cancion;
    }

    @Override
    public Cancion guardarCancion(Cancion cancion) {
       return this.cancionRepositorio.save(cancion);
    }

    @Override
    public void eliminarCancionPorId(Long idCancion) {
        this.cancionRepositorio.deleteById(idCancion);
    }
}
