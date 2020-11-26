package pe.edu.upc.greatstorage.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "rol")
    private String rol;

    @Column(name = "detail_rol")
    private String detailRol;

    public Rol() {
        super();
    }

    public Rol(Long idRol, String rol, String detailRol) {
        this.idRol = idRol;
        this.rol = rol;
        this.detailRol = detailRol;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDetailRol() {
        return detailRol;
    }

    public void setDetailRol(String detailRol) {
        this.detailRol = detailRol;
    }
}
