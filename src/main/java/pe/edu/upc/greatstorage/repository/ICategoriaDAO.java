package pe.edu.upc.greatstorage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.greatstorage.model.Categoria;

import java.util.List;

@Repository
public interface ICategoriaDAO extends CrudRepository<Categoria, Long> {
    List<Categoria> findAllByOrderByNombreCategoriaAsc();
    List<Categoria> findByNombreCategoriaContainingIgnoreCaseOrderByNombreCategoriaAsc(String nombreCategoria);
    Categoria findByNombreCategoria(String nombreCategoria);
}
