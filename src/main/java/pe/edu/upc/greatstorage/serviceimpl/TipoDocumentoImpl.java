package pe.edu.upc.greatstorage.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greatstorage.model.TipoDocumento;
import pe.edu.upc.greatstorage.repository.ITipoDocumentoDAO;
import pe.edu.upc.greatstorage.service.ITipoDocumentoService;

import java.util.List;

@Service
public class TipoDocumentoImpl implements ITipoDocumentoService {

    @Autowired
    private ITipoDocumentoDAO data;

    @Override
    public List<TipoDocumento> Mostrar() {
        return (List<TipoDocumento>) data.findAll();
    }
}
