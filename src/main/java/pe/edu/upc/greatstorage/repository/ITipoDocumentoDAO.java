package pe.edu.upc.greatstorage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.greatstorage.model.TipoDocumento;

@Repository
public interface ITipoDocumentoDAO extends CrudRepository<TipoDocumento,Integer> {
}
