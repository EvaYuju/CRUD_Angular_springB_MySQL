package com.angular_springb_sql.crud.repository;

import com.angular_springb_sql.crud.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository         // 2 param:  Tipo de dato y tipo de dato de la PK
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Buscar por nombre
    Optional<Producto> findByNombre(String nombre); /* Nomenclatura para JPA findByNombreAtributo etc */
    // Comprueba si existe por nombre
    boolean existsByNombre(String nombre);

}
