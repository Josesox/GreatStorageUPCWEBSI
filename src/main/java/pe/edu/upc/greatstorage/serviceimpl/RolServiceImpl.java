package pe.edu.upc.greatstorage.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greatstorage.model.Rol;
import pe.edu.upc.greatstorage.repository.IRolDAO;
import pe.edu.upc.greatstorage.service.IRolService;

import java.util.List;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolDAO data;

    @Override
    public List<Rol> Mostrar() {
        return data.findAllByOrderByRolAsc();
    }
}
