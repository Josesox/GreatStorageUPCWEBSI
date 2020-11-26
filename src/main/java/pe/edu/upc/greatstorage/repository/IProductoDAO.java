package pe.edu.upc.greatstorage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.greatstorage.model.Categoria;
import pe.edu.upc.greatstorage.model.Producto;

import java.util.List;

@Repository
public interface IProductoDAO extends CrudRepository<Producto, Long> {
    List<Producto> findAllByOrderByNombreProductoAsc();
    List<Producto> findByNombreProductoContainingIgnoreCaseOrderByNombreProductoAsc(String nombreProducto);
    Producto findByNombreProducto(String nombreProducto);
    List<Producto> findByCategoriaOrderByNombreProductoAsc(Categoria idCategory);
}
