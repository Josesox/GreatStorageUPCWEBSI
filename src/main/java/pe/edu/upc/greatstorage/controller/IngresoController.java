package pe.edu.upc.greatstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greatstorage.model.Categoria;
import pe.edu.upc.greatstorage.model.Ingreso;
import pe.edu.upc.greatstorage.model.Producto;
import pe.edu.upc.greatstorage.service.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class IngresoController
{
    @Autowired
    private IIngresoService ingresoservice;

    @Autowired
    private ITipoComprobanteService tipocomprobanteservice;

    @Autowired
    private IProductoService productoservice;

    @Autowired
    private IProveedorService proveedorservice;

    @GetMapping("/ingresos")
    String Mostrar(Model model) {
        List<Ingreso> ingresos = ingresoservice.Mostrar();
        model.addAttribute("ingresos", ingresos);
        return "ingreso";
    }

    @GetMapping("/ingresos/nuevo")
    public String GuardarMethod(Model model, @RequestParam(value = "rate", required = false) Integer rate) {
        model.addAttribute("ingreso", new Ingreso());
        model.addAttribute("listaproductos", productoservice.Mostrar());
        model.addAttribute("listatipocomprobante", tipocomprobanteservice.Mostrar());
        model.addAttribute("listaproveedores", proveedorservice.MostrarByRate(rate));
        return "newingreso";
    }

    @PostMapping("/ingresos/guardar")
    public String Guardar(@Valid Ingreso i, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listaproductos", productoservice.Mostrar());
            model.addAttribute("listatipocomprobante", tipocomprobanteservice.Mostrar());
            model.addAttribute("listaproveedores", proveedorservice.Mostrar());

            return "newingreso";
        }
        ingresoservice.Guardar(i);
        Long id = i.getIdIngreso();
        return "redirect:/ingresos/orden/"+id;
    }

    @GetMapping("/ingresos/eliminar/{id}")
    public String Eliminar(@PathVariable Long id) {
        ingresoservice.Eliminar(id);
        return "redirect:/ingresos";
    }

    @GetMapping("/ingresos/buscar")
    public String Buscar(Model model, @RequestParam("fechainicio") LocalDate fechainicio, @RequestParam("fechafin") LocalDate fechafin) {
        List<Ingreso> ingresos = ingresoservice.BuscarEntreFechas(fechainicio,fechafin);
        model.addAttribute("ingresos", ingresos);

        return "ingreso";
    }

    @GetMapping("/ingresos/detalle/{id}")
    public String Detalle(@PathVariable Long id, Model model, @RequestParam("idCategory") Categoria idCategory){
        Optional<Ingreso> ingreso = ingresoservice.BuscarId(id);
        List<Producto> productos = productoservice.BuscarPorCategory(idCategory);
        model.addAttribute("ingreso", ingreso);
        model.addAttribute("productos", productos);
        return "detailingreso";
    }

    @GetMapping("/ingresos/historial")
    String MostrarHistorial(Model model) {
        List<Ingreso> ingresos = ingresoservice.MostrarDesc();
        model.addAttribute("ingresos", ingresos);
        return "historial";
    }

    @GetMapping("/ingresos/orden/{id}")
    public String Detalle(@PathVariable Long id, Model model){
        Optional<Ingreso> ingreso = ingresoservice.BuscarId(id);
        model.addAttribute("ingreso", ingreso);
        return "ordeningreso";
    }

    @GetMapping("/ingresos/solicitud/{id}")
    public String SolicitudMethod(@PathVariable Long id, Model model) {
        model.addAttribute("ingreso", new Ingreso());
        model.addAttribute("listatipocomprobante", tipocomprobanteservice.Mostrar());
        model.addAttribute("listaproductos", productoservice.Mostrar());
        model.addAttribute("listaproveedores", proveedorservice.Mostrar());

        return "solicitudstock";
    }

    @PostMapping("/ingresos/enviar")
    public String Enviar(@Valid Ingreso i, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listatipocomprobante", tipocomprobanteservice.Mostrar());
            model.addAttribute("listaproveedores", proveedorservice.Mostrar());
            model.addAttribute("listaproductos", productoservice.Mostrar());
            return "solicitudstock";
        }
        ingresoservice.Guardar(i);
        return "redirect:/ingresos";
    }
}
