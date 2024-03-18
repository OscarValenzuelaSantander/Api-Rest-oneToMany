package com.scd.oscarvalenzuela.servicio;

import com.scd.oscarvalenzuela.modelo.Cancion;

import java.util.List;

public interface ICancionServicio {
    public List<Cancion> listarCancion();
    public Cancion buscarCancionPorId(Long idCancion);
    public Cancion guardarCancion(Cancion cancion);
    public void eliminarCancionPorId(Long idCancion);
}
