package pe.edu.upc.greatstorage.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.greatstorage.model.Usuario;
import pe.edu.upc.greatstorage.repository.IUsuarioDAO;
import pe.edu.upc.greatstorage.service.IUsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDAO data;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<Usuario> Mostrar() {
        return data.findAllByOrderByNombreUsuarioAsc();
    }

    @Override
    public Optional<Usuario> BuscarId(Long id) {
        return data.findById(id);
    }

    @Override
    public List<Usuario> BuscarUsuario(String textobusar) {
        return data.findByNombreUsuarioContainingIgnoreCaseOrderByNombreUsuarioAsc(textobusar);
    }

    @Override
    public Long Guardar(Usuario usuario) {
        long rpta = 0;

        usuario.setPassword(usuario.getPassworddecrypt());

        String encodePassword = bCryptPasswordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encodePassword);

        Usuario u = data.save(usuario);

        if (!u.equals(null))
        {
            rpta = 1;
        }
        return rpta;
    }

    @Override
    public void Eliminar(Long id) {
        data.deleteById(id);
    }

    @Override
    public Usuario ValidarUsername(String username) {
        return data.findByUsername(username);
    }
}
