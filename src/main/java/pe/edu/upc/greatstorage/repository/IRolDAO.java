package pe.edu.upc.greatstorage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.greatstorage.model.Rol;

import java.util.List;

@Repository
public interface IRolDAO extends CrudRepository<Rol,Long> {
    List<Rol> findAllByOrderByRolAsc();
}
