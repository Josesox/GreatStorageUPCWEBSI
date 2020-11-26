package pe.edu.upc.greatstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.greatstorage.model.Categoria;
import pe.edu.upc.greatstorage.service.ICategoriaService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class CategoriaController {
    @Autowired
    private ICategoriaService service;

    @GetMapping("/categorias")
    public String Mostrar(Model model) {
        List<Categoria> categorias = service.Mostrar();
        model.addAttribute("categorias", categorias);
        return "categoria";
    }

    @GetMapping("/categorias/nuevo")
    public String GuardarMethod(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "newcategoria";
    }

    @PostMapping("/categorias/guardar")
    public String Guardar(@Valid Categoria c, BindingResult result) {

        Categoria categoriaexistente = service.ValidarNombre(c.getNombreCategoria());

        if (categoriaexistente != null)
        {
            result.rejectValue("nombreCategoria","error.nombreCategoria","Ya existe una categoria con ese nombre en la Base de Datos");
        }
        if (result.hasErrors()) {
            return "newcategoria";
        }
        service.Guardar(c);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/editar/{id}")
    public String Editar(@PathVariable Long id, Model model) {
        Optional<Categoria> categoria = service.BuscarId(id);
        model.addAttribute("categoria", categoria);
        return "updatecategoria";
    }

    @PostMapping("/categorias/actualizar")
    public String EditarMethod(@Valid Categoria c, BindingResult result) {
        if (result.hasErrors()) {
            return "updatecategoria";
        }

        service.Guardar(c);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/eliminar/{id}")
    public String Eliminar(@PathVariable Long id) {
        service.Eliminar(id);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/buscar")
    public String Buscar(Model model, @Param("keyword") String keyword) {
        List<Categoria> categorias = service.BuscarNombre(keyword);
        model.addAttribute("categorias", categorias);

        return "categoria";
    }
}
