package pe.edu.upc.greatstorage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.greatstorage.model.TipoComprobante;

@Repository
public interface ITipoComprobanteDAO extends CrudRepository<TipoComprobante,Integer> {
}
