package pe.edu.upc.greatstorage.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greatstorage.model.TipoComprobante;
import pe.edu.upc.greatstorage.repository.ITipoComprobanteDAO;
import pe.edu.upc.greatstorage.service.ITipoComprobanteService;

import java.util.List;

@Service
public class TipoComprobanteImpl implements ITipoComprobanteService {
    @Autowired
    private ITipoComprobanteDAO data;

    @Override
    public List<TipoComprobante> Mostrar() {
        return (List<TipoComprobante>) data.findAll();
    }
}
