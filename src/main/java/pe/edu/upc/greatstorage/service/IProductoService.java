package pe.edu.upc.greatstorage.service;

import pe.edu.upc.greatstorage.model.Categoria;
import pe.edu.upc.greatstorage.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    public List<Producto> Mostrar();
    public Optional<Producto> BuscarId(Long id);
    public List<Producto> BuscarNombre(String textobuscar);
    public Long Guardar(Producto producto);
    public void Eliminar(Long id);
    public Producto ValidarNombre(String nombreProducto);
    public List<Producto> BuscarPorCategory(Categoria idCategory);
}
