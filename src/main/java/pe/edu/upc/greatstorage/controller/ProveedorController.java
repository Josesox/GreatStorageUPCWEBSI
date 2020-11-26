package pe.edu.upc.greatstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.greatstorage.model.Proveedor;
import pe.edu.upc.greatstorage.service.IProveedorService;
import pe.edu.upc.greatstorage.service.ITipoDocumentoService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ProveedorController {

    @Autowired
    private IProveedorService service;

    @Autowired
    private ITipoDocumentoService tdservice;

    @GetMapping("/proveedores")
    public String Mostrar(Model model) {
        List<Proveedor> proveedores = service.Mostrar();
        model.addAttribute("proveedores", proveedores);
        return "proveedor";
    }

    @GetMapping("/proveedores/nuevo")
    public String GuardarMethod(Model model)
    {
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("listatipodocumento", tdservice.Mostrar());
        return "newproveedor";
    }

    @PostMapping("/proveedores/guardar")
    public String Guardar(@Valid Proveedor p, BindingResult result, Model model)
    {
        Proveedor proveedorexistente = service.ValidarNombre(p.getNombreProveedor());
        if (proveedorexistente != null)
        {
            result.rejectValue("nombreProveedor","error.nombreProveedor","Ya existe un proveedor con ese nombre en la Base de Datos");
        }

        if (result.hasErrors()) {
            model.addAttribute("listatipodocumento",tdservice.Mostrar());

            return "newproveedor";
        }
        service.Guardar(p);
        return "redirect:/proveedores";
    }

    @GetMapping("/proveedores/editar/{id}")
    public String Editar(@PathVariable Long id, Model model)
    {
        model.addAttribute("listatipodocumento",tdservice.Mostrar());
        Optional<Proveedor> proveedor = service.BuscarId(id);
        proveedor.ifPresent(o -> model.addAttribute("proveedor",o));
        return "updateproveedor";
    }

    @PostMapping("/proveedores/actualizar")
    public String EditarMethod(@Valid Proveedor p, BindingResult result, Model model) {
        if (result.hasErrors())
        {
            model.addAttribute("listatipodocumento",tdservice.Mostrar());

            return "updateproveedor";
        }

        service.Guardar(p);
        return "redirect:/proveedores";
    }

    @GetMapping("/proveedores/eliminar/{id}")
    public String Eliminar(@PathVariable Long id) {
        service.Eliminar(id);
        return "redirect:/proveedores";
    }

    @GetMapping("/proveedores/buscar")
    public String Buscar(Model model, @Param("keyword") String keyword) {
        List<Proveedor> proveedores = service.BuscarNombre(keyword);
        model.addAttribute("proveedores", proveedores);

        return "proveedor";
    }

    @GetMapping("/proveedores/calificar/{id}")
    public String EditarCalificacion(@PathVariable Long id, Model model)
    {
        model.addAttribute("listatipodocumento",tdservice.Mostrar());
        Optional<Proveedor> proveedor = service.BuscarId(id);
        proveedor.ifPresent(o -> model.addAttribute("proveedor",o));
        return "rateproveedor";
    }

    @PostMapping("/proveedores/calificar")
    public String Calificar(@Valid Proveedor p, BindingResult result, Model model) {

        if (result.hasErrors())
        {
            model.addAttribute("listatipodocumento",tdservice.Mostrar());

            return "rateproveedor";
        }

        service.Guardar(p);
        return "redirect:/ingresos";

    }

    @GetMapping("/proveedores/rates")
    public String BuscarRates(Model model, @RequestParam("rate") Integer rate) {
        List<Proveedor> proveedores = service.MostrarByRate(rate);
        model.addAttribute("proveedores", proveedores);

        return "newingreso";
    }
}
