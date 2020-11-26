package pe.edu.upc.greatstorage.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greatstorage.model.Categoria;
import pe.edu.upc.greatstorage.repository.IMarcaDAO;
import pe.edu.upc.greatstorage.service.IMarcaService;
import pe.edu.upc.greatstorage.model.Marca;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements IMarcaService {
    @Autowired
    private IMarcaDAO data;

    @Override
    public List<Marca> Mostrar() {
        return data.findAllByOrderByNombreMarcaAsc();
    }

    @Override
    public Optional<Marca> BuscarId(Long id) {
        return data.findById(id);
    }

    @Override
    public List<Marca> BuscarNombre(String textobuscar) {
        return data.findByNombreMarcaContainingIgnoreCaseOrderByNombreMarcaAsc(textobuscar);
    }

    @Override
    public Long Guardar(Marca marca) {
        long rpta = 0;
        Marca m = data.save(marca);

        if (!m.equals(null)) {
            rpta = 1;
        }

        return rpta;
    }

    @Override
    public void Eliminar(Long id) {
        data.deleteById(id);
    }

    @Override
    public Marca ValidarNombre(String nombreMarca) {
        return data.findByNombreMarca(nombreMarca);
    }
}
