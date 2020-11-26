package pe.edu.upc.greatstorage.controller;

import com.sun.org.apache.bcel.internal.generic.LSTORE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.greatstorage.model.Categoria;
import pe.edu.upc.greatstorage.model.Marca;
import pe.edu.upc.greatstorage.model.Producto;
import pe.edu.upc.greatstorage.service.ICategoriaService;
import pe.edu.upc.greatstorage.service.IMarcaService;
import pe.edu.upc.greatstorage.service.IProductoService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ProductoController
{
    @Autowired
    private IProductoService service;

    @Autowired
    private ICategoriaService catservice;

    @Autowired
    private IMarcaService marservice;

    @GetMapping("/productos")
    public String Mostrar(Model model) {
        List<Producto> productos = service.Mostrar();
        model.addAttribute("productos", productos);
        return "producto";
    }

    @GetMapping("/productos/nuevo")
    public String GuardarMethod(Model model)
    {
        model.addAttribute("producto", new Producto());
        model.addAttribute("listacategorias", catservice.Mostrar());
        model.addAttribute("listamarcas",marservice.Mostrar());
        return "newproducto";
    }

    @PostMapping("/productos/guardar")
    public String Guardar(@Valid Producto p, BindingResult result, Model model)
    {
        Producto productoexistente = service.ValidarNombre(p.getNombreProducto());
        if (productoexistente != null)
        {
            result.rejectValue("nombreProducto","error.nombreProducto","Ya existe un producto con ese nombre en la Base de Datos");
        }

        if (result.hasErrors()) {
            model.addAttribute("listacategorias",catservice.Mostrar());
            model.addAttribute("listamarcas",marservice.Mostrar());

            return "newproducto";
        }
        service.Guardar(p);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String Editar(@PathVariable Long id, Model model)
    {
        model.addAttribute("listacategorias",catservice.Mostrar());
        model.addAttribute("listamarcas", marservice.Mostrar());
        Optional<Producto> producto = service.BuscarId(id);
        producto.ifPresent(o -> model.addAttribute("producto",o));
        return "updateproducto";
    }

    @PostMapping("/productos/actualizar")
    public String EditarMethod(@Valid Producto p, BindingResult result, Model model) {
        if (result.hasErrors())
        {
            model.addAttribute("listacategorias",catservice.Mostrar());
            model.addAttribute("listamarcas",marservice.Mostrar());

            return "updateproducto";
        }

        service.Guardar(p);
        return "redirect:/productos";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String Eliminar(@PathVariable Long id) {
        service.Eliminar(id);
        return "redirect:/productos";
    }

    @GetMapping("/productos/buscar")
    public String Buscar(Model model, @Param("keyword") String keyword) {
        List<Producto> productos = service.BuscarNombre(keyword);
        model.addAttribute("productos", productos);

        return "producto";
    }
}
