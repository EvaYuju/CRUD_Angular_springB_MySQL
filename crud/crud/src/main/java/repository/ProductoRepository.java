package repository;

import entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> { // Tipo de dato y tipo de dato de la PK
    Optional<Producto> findByNombre(String nombre);
    boolean existByNombre(String nombre);
}
