package pe.edu.upc.greatstorage.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "marca")

public class Marca implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Long idMarca;

    @Column(name = "nombre_marca", length = 55, nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    private String nombreMarca;

    @Column(name = "descripcion_marca", length = 255, nullable = true)
    private String descripcionMarca;

    public Marca() {
        super();
    }

    public Marca(Long idMarca, String nombreMarca, String descripcionMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.descripcionMarca = descripcionMarca;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getDescripcionMarca() {
        return descripcionMarca;
    }

    public void setDescripcionMarca(String descripcionMarca) {
        this.descripcionMarca = descripcionMarca;
    }
}
