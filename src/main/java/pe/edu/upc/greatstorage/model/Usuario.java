package pe.edu.upc.greatstorage.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario", nullable = false, length = 30)
    @NotEmpty(message = "No puede dejar este campo vacio")
    private String nombreUsuario;

    @Column(name = "apellido_usuario", nullable = false, length = 60)
    @NotEmpty(message = "No puede dejar este campo vacio")
    private String apellidoUsuario;

    @ManyToOne
    @JoinColumn(name = "id_tipodocumento")
    private TipoDocumento tipodocumentoUsuario;

    @Column(name = "numerodocumento_usuario", nullable = false, length = 12)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]{8,12}", message = "Solamente puede ingresar digitos de 8 hasta 12 caracteres")
    private String numerodocumentoUsuario;

    @Column(name = "username", nullable = false, length = 50)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Size(min = 4, message = "El usuario debe ser minimo de 4 caracteres")
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @NotEmpty(message = "No puede dejar este campo vacio")
    @Size(min = 4, message = "La contraseña debe ser minimo de 4 caracteres")
    @Column(name = "password_descrypt", nullable = false, length = 255)
    private String passworddecrypt;

    @Column(name = "telefono_usuario", length = 15, nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]{7,15}", message = "Solamente puede ingresar digitos de 7 hasta 15 caracteres")
    private String telefonoUsuario;

    @Column(name = "email_usuario", length = 50, nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Email(message = "Credencial no permitida para el campo")
    private String emailUsuario;

    @ManyToMany(fetch = FetchType.LAZY, cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            })
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"))
    private List<Rol> roles;

    public Usuario() {
        super();
    }

    public Usuario(Long idUsuario, String nombreUsuario, String apellidoUsuario, TipoDocumento tipodocumentoUsuario, String numerodocumentoUsuario, String username,
                   String password, String passworddecrypt, String telefonoUsuario, String emailUsuario, List<Rol> roles) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.tipodocumentoUsuario = tipodocumentoUsuario;
        this.numerodocumentoUsuario = numerodocumentoUsuario;
        this.username = username;
        this.password = password;
        this.passworddecrypt = passworddecrypt;
        this.telefonoUsuario = telefonoUsuario;
        this.emailUsuario = emailUsuario;
        this.roles = roles;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public TipoDocumento getTipodocumentoUsuario() {
        return tipodocumentoUsuario;
    }

    public void setTipodocumentoUsuario(TipoDocumento tipodocumentoUsuario) {
        this.tipodocumentoUsuario = tipodocumentoUsuario;
    }

    public String getNumerodocumentoUsuario() {
        return numerodocumentoUsuario;
    }

    public void setNumerodocumentoUsuario(String numerodocumentoUsuario) {
        this.numerodocumentoUsuario = numerodocumentoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public String getPassworddecrypt() {
        return passworddecrypt;
    }

    public void setPassworddecrypt(String passworddecrypt) {
        this.passworddecrypt = passworddecrypt;
    }
}
