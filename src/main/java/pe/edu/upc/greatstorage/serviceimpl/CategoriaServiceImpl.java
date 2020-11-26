package pe.edu.upc.greatstorage.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greatstorage.repository.ICategoriaDAO;
import pe.edu.upc.greatstorage.service.ICategoriaService;
import pe.edu.upc.greatstorage.model.Categoria;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
    @Autowired
    private ICategoriaDAO data;

    @Override
    public List<Categoria> Mostrar() {
        return data.findAllByOrderByNombreCategoriaAsc();
    }

    @Override
    public Optional<Categoria> BuscarId(Long id) {
        return data.findById(id);
    }

    @Override
    public List<Categoria> BuscarNombre(String textobuscar) {
        return data.findByNombreCategoriaContainingIgnoreCaseOrderByNombreCategoriaAsc(textobuscar);
    }

    @Override
    public Long Guardar(Categoria categoria) {
        long rpta = 0;
        Categoria c = data.save(categoria);

        if (!c.equals(null)) {
            rpta = 1;
        }

        return rpta;
    }

    @Override
    public void Eliminar(Long id) {
        data.deleteById(id);
    }

    @Override
    public Categoria ValidarNombre(String nombreCategoria) {
        return data.findByNombreCategoria(nombreCategoria);
    }
}
