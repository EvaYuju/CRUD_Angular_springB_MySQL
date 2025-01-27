package service;

import dto.ProductoDto;
import entity.Producto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {
    //Inyectar el repositorio;
    @Autowired // Cuando sea necesario se encargue Spring de crear una instancia del Repositorio
    ProductoRepository productoRepository;
    // Métodos:
    // Devuelve todos los registros de esa tabla:
    public List<Producto> list(){
        return productoRepository.findAll();
    }
    // Optional y Devuelve por el id:
    public Optional<Producto> getOne(int id){
        return productoRepository.findById(id);
    }
    // Devuelve por el nombre
    public Optional<Producto> getByNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }
    // No devuelve -> para guardar
    public void save(Producto producto){
        productoRepository.save(producto);
    }
    // Para borrar
    public void delete(int id){
        productoRepository.deleteById(id);
    }
    // Para comprobar si existe por id o nombre:
    public boolean existsById(int id){
        return productoRepository.existsById(id);
    }
    public boolean existsByNombre(String nombre){
        return productoRepository.existByNombre(nombre);
    }


}
