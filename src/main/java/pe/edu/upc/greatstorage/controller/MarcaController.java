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
import pe.edu.upc.greatstorage.model.Marca;
import pe.edu.upc.greatstorage.service.IMarcaService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class
MarcaController {
    @Autowired
    private IMarcaService service;

    @GetMapping("/marcas")
    public String Mostrar(Model model) {
        List<Marca> marcas = service.Mostrar();
        model.addAttribute("marcas", marcas);
        return "marca";
    }

    @GetMapping("/marcas/nuevo")
    public String GuardarMethod(Model model) {
        model.addAttribute("marca", new Marca());
        return "newmarca";
    }

    @PostMapping("/marcas/guardar")
    public String Guardar(@Valid Marca m, BindingResult result) {
        Marca marcaexistente = service.ValidarNombre(m.getNombreMarca());
        if(marcaexistente != null)
        {
            result.rejectValue("nombreMarca","error.nombreMarca","Ya existe una marca con ese nombre en la Base de Datos");
        }
        if (result.hasErrors()) {
            return "newmarca";
        }
        service.Guardar(m);
        return "redirect:/marcas";
    }

    @GetMapping("/marcas/editar/{id}")
    public String Editar(@PathVariable Long id, Model model) {
        Optional<Marca> marca = service.BuscarId(id);
        model.addAttribute("marca", marca);
        return "updatemarca";
    }

    @PostMapping("/marcas/actualizar")
    public String EditarMethod(@Valid Marca m, BindingResult result) {
        if (result.hasErrors()) {
            return "updatemarca";
        }

        service.Guardar(m);
        return "redirect:/marcas";
    }

    @GetMapping("/marcas/eliminar/{id}")
    public String Eliminar(@PathVariable Long id) {
        service.Eliminar(id);
        return "redirect:/marcas";
    }

    @GetMapping("/marcas/buscar")
    public String Buscar(Model model, @Param("keyword") String keyword) {
        List<Marca> marcas = service.BuscarNombre(keyword);
        model.addAttribute("marcas", marcas);

        return "marca";
    }
}
