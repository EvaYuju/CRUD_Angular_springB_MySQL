package controller;

import dto.Mensaje;
import dto.ProductoDto;
import entity.Producto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductoService;

import java.util.List;

@RestController // Indicamos que es una APIRest
@RequestMapping("/producto") // url localhost:8080/producto
//@CrossOrigin(origins="*") // * servicio desde cualquier url
@CrossOrigin(origins="http://localhost:4200") // servicio en el puerto de angular
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/lista") //url
    public ResponseEntity<List<Producto>> list() {
        List<Producto> list = productoService.list();
        // return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        // Si existe creramos un producto
        Producto producto = productoService.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }
    @GetMapping("/detail/{nombre}")
    public ResponseEntity<Producto> getByNombre(@PathVariable("nombre") String nombre){
        if(!productoService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND); // 404
        // Si existe creramos un producto
        Producto producto = productoService.getByNombre(nombre).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductoDto productoDto){
        // SpringUtils de Apache commons lang3
        if(StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoDto.getPrecio()<0)
            return new ResponseEntity<>(new Mensaje("El precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(productoService.existsByNombre(productoDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        Producto producto = new Producto(productoDto.getNombre(),productoDto.getPrecio());
        productoService.save(producto);
        return new ResponseEntity<>(new Mensaje("Producto creado"), HttpStatus.OK); // 200
    }

    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProductoDto productoDto){
        // Comprobamos si existe primero
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(productoService.existsByNombre(productoDto.getNombre()) && productoService.getByNombre(productoDto.getNombre()).get().getId() !=id)
            return new ResponseEntity<>(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        // SpringUtils de Apache commons lang3
        if(StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoDto.getPrecio()<0)
            return new ResponseEntity<>(new Mensaje("El precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        //Producto producto = new Producto(productoDto.getNombre(),productoDto.getPrecio());
        Producto producto = productoService.getOne(id).get();
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        productoService.save(producto);
        return new ResponseEntity<>(new Mensaje("Producto creado"), HttpStatus.OK); // 200
    }

}
