package pe.edu.upc.greatstorage.serviceimpl;

import javassist.compiler.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greatstorage.model.Ingreso;
import pe.edu.upc.greatstorage.repository.IIngresoDAO;
import pe.edu.upc.greatstorage.service.IIngresoService;
import pe.edu.upc.greatstorage.service.IProductoService;

import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Service
public class IngresoServiceImpl implements IIngresoService {

    @Autowired
    private IIngresoDAO data;

    @Autowired
    private IProductoService productoservice;

    @Override
    public List<Ingreso> Mostrar() {
        return data.findAllByOrderByIdIngresoAsc();
    }

    @Override
    public Long Guardar(Ingreso ingreso) {

        ingreso.setFechaIngreso(LocalDate.now());
        ingreso.setTotal(Double.parseDouble(ingreso.getPrecioCompra()) * Integer.parseInt(ingreso.getStock()));

        long rpta = 0;
        Ingreso i = data.save(ingreso);

        if (!i.equals(null)) {
            rpta = 1;
        }

        return rpta;
    }

    @Override
    public void Eliminar(Long id) {
        data.deleteById(id);
    }


    @Override
    public List<Ingreso> BuscarEntreFechas(LocalDate fechainicio, LocalDate fechafin) {
        return data.findByFechaIngresoBetween(fechainicio,fechafin);
    }

    @Override
    public Optional<Ingreso> BuscarId(Long id) {
        return data.findById(id);
    }

    @Override
    public List<Ingreso> MostrarDesc() {
        return data.findAllByOrderByIdIngresoDesc();
    }
}
