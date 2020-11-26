package pe.edu.upc.greatstorage.service;

import pe.edu.upc.greatstorage.model.Proveedor;

import java.util.List;
import java.util.Optional;

public interface IProveedorService {
    public List<Proveedor> Mostrar();
    public Optional<Proveedor> BuscarId(Long id);
    public List<Proveedor> BuscarNombre(String textobuscar);
    public Long Guardar(Proveedor proveedor);
    public void Eliminar(Long id);
    public Proveedor ValidarNombre(String nombreProveedor);

    public List<Proveedor> MostrarByRate(Integer rateProveedor);
}
