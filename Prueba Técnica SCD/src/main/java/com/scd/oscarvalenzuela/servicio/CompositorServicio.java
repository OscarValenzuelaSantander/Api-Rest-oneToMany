package com.scd.oscarvalenzuela.servicio;

import com.scd.oscarvalenzuela.modelo.Compositor;
import com.scd.oscarvalenzuela.repositorio.CompositorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompositorServicio implements ICompositorServicio{

    @Autowired
    private CompositorRepositorio compositorRepositorio;

    @Override
    public List<Compositor> listarCompositor() {
       return this.compositorRepositorio.findAll();
    }

    @Override
    public Compositor buscarCompositorPorId(Long idCompositor) {
        Compositor compositor = this.compositorRepositorio.findById(idCompositor).orElse(null);
        return compositor;
    }

    @Override
    public Compositor guardarCompositor(Compositor compositor) {
       return this.compositorRepositorio.save(compositor);
    }

    @Override
    public void eliminarCompositorPorId(Long idCompositor) {
        this.compositorRepositorio.deleteById(idCompositor);
    }
}
