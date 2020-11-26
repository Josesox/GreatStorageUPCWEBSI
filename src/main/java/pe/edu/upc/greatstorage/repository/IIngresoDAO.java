package pe.edu.upc.greatstorage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.greatstorage.model.Ingreso;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IIngresoDAO extends CrudRepository<Ingreso,Long> {
    List<Ingreso> findAllByOrderByIdIngresoAsc();
    List<Ingreso> findByFechaIngresoBetween(LocalDate fechainicio, LocalDate fechafin);
    List<Ingreso> findAllByOrderByIdIngresoDesc();
}
