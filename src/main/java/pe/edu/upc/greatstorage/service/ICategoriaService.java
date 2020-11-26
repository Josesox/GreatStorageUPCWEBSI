package pe.edu.upc.greatstorage.service;

import pe.edu.upc.greatstorage.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {

    public List<Categoria> Mostrar();
    public Optional<Categoria> BuscarId(Long id);
    public List<Categoria> BuscarNombre(String textobuscar);
    public Long Guardar(Categoria categoria);
    public void Eliminar(Long id);
    public Categoria ValidarNombre(String nombreCategoria);
}
