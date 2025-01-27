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

@RestController /* Indicamos que es una APIRest */
@RequestMapping("/producto") /* url localhost:8080/producto */
//@CrossOrigin(origins="*") /* servicio desde cualquier url */
@CrossOrigin(origins="http://localhost:4200") /* servicio en el puerto de angular */
public class ProductoController {
    // Inyectar el Service:
    @Autowired
    ProductoService productoService;

    // Métodos
    /* GET */
    @GetMapping("/lista") /* Get mapping + url ; producto/lista */
    public ResponseEntity<List<Producto>> list() {
        List<Producto> list = productoService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
        // return new ResponseEntity<List<Producto>>(list, HttpStatus.OK); /* Hace lo mismo */
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id){
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        // Si existe encuentra un id producto
        Producto producto = productoService.getOne(id).get(); /* Optional -> .get() */
        return new ResponseEntity(producto, HttpStatus.OK);
    }
    @GetMapping("/detail/{nombre}")
    public ResponseEntity<Producto> getByNombre(@PathVariable("nombre") String nombre){
        if(!productoService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND); // 404
        // Si existe encuentra un nombre producto
        Producto producto = productoService.getByNombre(nombre).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    // Método Create
    @PostMapping("/create")     /* RequestBody -> pasar un JSON por Http*/
    public ResponseEntity<?> create(@RequestBody ProductoDto productoDto){
        // Comprobamos si existe primero, etc
        /* Uso SpringUtils de Apache commons lang3 */
        if(StringUtils.isBlank(productoDto.getNombre())) // isNotBlank -> que el nombre no esté en blanco
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoDto.getPrecio()<0)
      /*if(productoDto.getPrecio()<0 || productoDto.getPrecio()==null)*/ //Error? //ToDo
            return new ResponseEntity<>(new Mensaje("El precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(productoService.existsByNombre(productoDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        // Crea el producto
        Producto producto = new Producto(productoDto.getNombre(),productoDto.getPrecio());
        productoService.save(producto);
        return new ResponseEntity<>(new Mensaje("Producto creado"), HttpStatus.OK); // 200
    }

    // Método update
    /* PUT */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProductoDto productoDto){
        // Comprobamos si existe primero, etc
        if(!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND); // 404
        // Compruebo si el producto.nombre que pongo no existe en otro producto.id con ese nombre
        if(productoService.existsByNombre(productoDto.getNombre()) && productoService.getByNombre(productoDto.getNombre()).get().getId() !=id)
            return new ResponseEntity<>(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoDto.getPrecio()<0)
            return new ResponseEntity<>(new Mensaje("El precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        Producto producto = productoService.getOne(id).get(); /* Obtengo el producto mediante del id */
        producto.setNombre(productoDto.getNombre()); /* Asignamos nombre */
        producto.setPrecio(productoDto.getPrecio()); /* Asignamos precio */
        productoService.save(producto); /* guardamos */
        return new ResponseEntity<>(new Mensaje("Producto creado"), HttpStatus.OK); // 200
    }

}
