package com.scd.oscarvalenzuela.repositorio;

import com.scd.oscarvalenzuela.modelo.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepositorio extends JpaRepository <Cancion, Long>{
}
