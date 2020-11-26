package pe.edu.upc.greatstorage.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greatstorage.repository.IProductoDAO;
import pe.edu.upc.greatstorage.service.IProductoService;
import pe.edu.upc.greatstorage.model.Categoria;
import pe.edu.upc.greatstorage.model.Producto;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    private IProductoDAO data;

    @Override
    public List<Producto> Mostrar() {
        return data.findAllByOrderByNombreProductoAsc();
    }

    @Override
    public Optional<Producto> BuscarId(Long id) {
        return data.findById(id);
    }

    @Override
    public List<Producto> BuscarNombre(String textobuscar) {
        return data.findByNombreProductoContainingIgnoreCaseOrderByNombreProductoAsc(textobuscar);
    }

    @Override
    public Long Guardar(Producto producto) {
        long rpta = 0;
        Producto p = data.save(producto);

        if (!p.equals(null))
        {
            rpta = 1;
        }

        return  rpta;
    }

    @Override
    public void Eliminar(Long id)
    {
        data.deleteById(id);
    }

    @Override
    public Producto ValidarNombre(String nombreProducto) {
        return data.findByNombreProducto(nombreProducto);
    }

    @Override
    public List<Producto> BuscarPorCategory(Categoria idCategory) {
        return data.findByCategoriaOrderByNombreProductoAsc(idCategory);
    }
}
