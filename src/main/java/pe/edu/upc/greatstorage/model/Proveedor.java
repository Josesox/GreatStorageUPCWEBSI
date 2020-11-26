package pe.edu.upc.greatstorage.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long idProveedor;

    @Column(name = "nombre_proveedor", length = 80, nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    private String nombreProveedor;

    @ManyToOne
    @JoinColumn(name = "id_tipodocumento", nullable = false)
    private TipoDocumento tipodocumentoProveedor;

    @Column(name = "numerodocumento_proveedor", nullable = false, length = 12)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]{8,12}", message = "Solamente puede ingresar digitos de 8 hasta 12 caracteres")
    private String numerodocumentoProveedor;

    @Column(name = "direccion_proveedor", length = 255, nullable = true)
    private String direcccionProveedor;

    @Column(name = "telefono_proveedor", length = 15, nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]{7,15}", message = "Solamente puede ingresar digitos de 7 hasta 15 caracteres")
    private String telefonoProveedor;

    @Column(name = "email_proveedor", length = 50, nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Email(message = "Credencial no permitida para el campo")
    private String emailProveedor;

    @Column(name = "rate_proveedor")
    private Integer rateProveedor;

    public Proveedor() {
        super();
    }

    public Proveedor(Long idProveedor, String nombreProveedor, TipoDocumento tipodocumentoProveedor, String numerodocumentoProveedor,
                     String direcccionProveedor, String telefonoProveedor, String emailProveedor, Integer rateProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.tipodocumentoProveedor = tipodocumentoProveedor;
        this.numerodocumentoProveedor = numerodocumentoProveedor;
        this.direcccionProveedor = direcccionProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.emailProveedor = emailProveedor;
        this.rateProveedor = rateProveedor;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public TipoDocumento getTipodocumentoProveedor() {
        return tipodocumentoProveedor;
    }

    public void setTipodocumentoProveedor(TipoDocumento tipodocumentoProveedor) {
        this.tipodocumentoProveedor = tipodocumentoProveedor;
    }

    public String getNumerodocumentoProveedor() {
        return numerodocumentoProveedor;
    }

    public void setNumerodocumentoProveedor(String numerodocumentoProveedor) {
        this.numerodocumentoProveedor = numerodocumentoProveedor;
    }

    public String getDirecccionProveedor() {
        return direcccionProveedor;
    }

    public void setDirecccionProveedor(String direcccionProveedor) {
        this.direcccionProveedor = direcccionProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public Integer getRateProveedor() {
        return rateProveedor;
    }

    public void setRateProveedor(Integer rateProveedor) {
        this.rateProveedor = rateProveedor;
    }

    
}
