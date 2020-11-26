package pe.edu.upc.greatstorage.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.DoubleStream;

@Entity
@Table(name = "ingreso")
public class Ingreso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso")
    private Long idIngreso;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    @Column(name = "fecha_ingreso")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "id_tipocomprobante", nullable = false)
    private TipoComprobante tipocomprobante;

    @Column(name = "numerocomprobante_ingreso", nullable = false, length = 15)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]{10,15}", message = "Solamente puede ingresar digitos de 10 hasta 15 caracteres")
    private String numerocomprobanteIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "stock")
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]+", message = "Solo se puede ingresar números")
    @Pattern(regexp = "^(?!0)[0-9]+", message = "Intervalo no permitido")
    private String stock;

    @Column(name = "precio_compra", nullable = false, precision = 8, scale = 2)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]*\\.[0-9]{2}$", message = "Solo se admite digitos con 2 decimales ( *.## )")
    @Pattern(regexp = "^(?!0.00)[0-9]*\\.[0-9]{2}$", message = "Intervalo no permitido")
    private String precioCompra;

    @Column(name = "precio_venta", nullable = false, precision = 8, scale = 2)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]*\\.[0-9]{2}$", message = "Solo se admite digitos con 2 decimales ( *.## )")
    @Pattern(regexp = "^(?!0.00)[0-9]*\\.[0-9]{2}$", message = "Intervalo no permitido")
    private String precioVenta;

    @Column(name = "total", precision = 8, scale = 2)
    private Double total;

    @Column(name = "solicitud", columnDefinition = "Integer default '0'")
    private Integer solicitud;

    public Ingreso() {
    }

    public Ingreso(Long idIngreso, Proveedor proveedor, LocalDate fechaIngreso, TipoComprobante tipocomprobante,
                   String numerocomprobanteIngreso, Producto producto, String stock, String precioCompra, String  precioVenta, Double total,
                   Integer solicitud) {
        this.idIngreso = idIngreso;
        this.proveedor = proveedor;
        this.fechaIngreso = fechaIngreso;
        this.tipocomprobante = tipocomprobante;
        this.numerocomprobanteIngreso = numerocomprobanteIngreso;
        this.producto = producto;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.total = total;
        this.solicitud = solicitud;
    }

    public Long getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public TipoComprobante getTipocomprobante() {
        return tipocomprobante;
    }

    public void setTipocomprobante(TipoComprobante tipocomprobante) {
        this.tipocomprobante = tipocomprobante;
    }

    public String getNumerocomprobanteIngreso() {
        return numerocomprobanteIngreso;
    }

    public void setNumerocomprobanteIngreso(String numerocomprobanteIngreso) {
        this.numerocomprobanteIngreso = numerocomprobanteIngreso;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Integer solicitud) {
        this.solicitud = solicitud;
    }
    
}

