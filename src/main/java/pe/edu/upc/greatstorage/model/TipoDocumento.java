package pe.edu.upc.greatstorage.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipodocumento")

public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipodocumento")
    private int idTipodocumento;

    @Column(name = "nombre_tipodocumento", length = 30, nullable = false)
    private String nombreTipodocumento;

    public TipoDocumento() {
        super();
    }

    public TipoDocumento(int idTipodocumento, String nombreTipodocumento) {
        this.idTipodocumento = idTipodocumento;
        this.nombreTipodocumento = nombreTipodocumento;
    }

    public int getIdTipodocumento() {
        return idTipodocumento;
    }

    public void setIdTipodocumento(int idTipodocumento) {
        this.idTipodocumento = idTipodocumento;
    }

    public String getNombreTipodocumento() {
        return nombreTipodocumento;
    }

    public void setNombreTipodocumento(String nombreTipodocumento) {
        this.nombreTipodocumento = nombreTipodocumento;
    }
}
