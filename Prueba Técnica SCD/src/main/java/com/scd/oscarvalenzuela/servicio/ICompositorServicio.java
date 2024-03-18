package com.scd.oscarvalenzuela.servicio;

import com.scd.oscarvalenzuela.modelo.Cancion;
import com.scd.oscarvalenzuela.modelo.Compositor;

import java.util.List;

public interface ICompositorServicio {
    public List<Compositor> listarCompositor();

    public Compositor buscarCompositorPorId(Long idCompositor);

    public Compositor guardarCompositor(Compositor compositor);

    public void eliminarCompositorPorId(Long idCompositor);
}
