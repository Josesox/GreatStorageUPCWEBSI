package pe.edu.upc.greatstorage.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.edu.upc.greatstorage.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<Usuario> Mostrar();
    public Optional<Usuario> BuscarId(Long id);
    public List<Usuario> BuscarUsuario(String textobusar);
    public Long Guardar(Usuario usuario);
    public void Eliminar(Long id);
    public Usuario ValidarUsername(String username);
}
