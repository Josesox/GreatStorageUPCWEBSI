package pe.edu.upc.greatstorage.service;

import pe.edu.upc.greatstorage.model.Marca;

import java.util.List;
import java.util.Optional;

public interface IMarcaService {

    public List<Marca> Mostrar();
    public Optional<Marca> BuscarId(Long id);
    public List<Marca> BuscarNombre(String textobuscar);
    public Long Guardar(Marca marca);
    public void Eliminar(Long id);
    public Marca ValidarNombre(String nombreMarca);
}
