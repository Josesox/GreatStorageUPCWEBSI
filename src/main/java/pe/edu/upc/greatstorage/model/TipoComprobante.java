package pe.edu.upc.greatstorage.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipocomprobante")
public class TipoComprobante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipocomprobante")
    private int idTipocomprobante;

    @Column(name = "nombre_tipocomprobante", length = 30, nullable = false)
    private String nombreTipocomprobante;

    public TipoComprobante() {
    }

    public TipoComprobante(int idTipocomprobante, String nombreTipocomprobante) {
        this.idTipocomprobante = idTipocomprobante;
        this.nombreTipocomprobante = nombreTipocomprobante;
    }

    public int getIdTipocomprobante() {
        return idTipocomprobante;
    }

    public void setIdTipocomprobante(int idTipocomprobante) {
        this.idTipocomprobante = idTipocomprobante;
    }

    public String getNombreTipocomprobante() {
        return nombreTipocomprobante;
    }

    public void setNombreTipocomprobante(String nombreTipocomprobante) {
        this.nombreTipocomprobante = nombreTipocomprobante;
    }
}
