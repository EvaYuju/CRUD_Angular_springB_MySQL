package service;

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
    @Autowired // Cuando sea necesario que se encargue Spring de crear una instancia del Repositorio
    ProductoRepository productoRepository;
    public List<Producto> list(){
        return productoRepository.findAll(); // Devuelve todos los registros de esa tabla
    }
    public Optional<Producto> getOne(int id){
        return productoRepository.findById(id); // Devuelve por el id
    }
    public Optional<Producto> getByNombre(String nombre){
        return productoRepository.findByNombre(nombre); // Devuelve por el nombre
    }
    public void save(Producto producto){
        productoRepository.save(producto);
    }
    public void delete(int id){
        productoRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return productoRepository.existsById(id);
    }
    public boolean existsByNombre(String nombre){
        return productoRepository.existByNombre(nombre);
    }


}
