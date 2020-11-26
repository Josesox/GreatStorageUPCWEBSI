package pe.edu.upc.greatstorage.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.greatstorage.model.Categoria;
import pe.edu.upc.greatstorage.model.Proveedor;

import java.util.List;

public interface IProveedorDAO extends CrudRepository<Proveedor,Long> {
    List<Proveedor> findAllByOrderByNombreProveedorAsc();
    List<Proveedor> findByNombreProveedorContainingIgnoreCaseOrderByNombreProveedorAsc(String nombreProveedor);
    Proveedor findByNombreProveedor(String nombreProveedor);
    List<Proveedor> findByRateProveedor(Integer rateProveedor);
}