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
import pe.edu.upc.greatstorage.model.Usuario;
import pe.edu.upc.greatstorage.service.IRolService;
import pe.edu.upc.greatstorage.service.ITipoDocumentoService;
import pe.edu.upc.greatstorage.service.IUsuarioService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class UsuarioController {

    @Autowired
    private ITipoDocumentoService tdservice;

    @Autowired
    private IUsuarioService userservice;

    @Autowired
    private IRolService rolservice;

    @GetMapping("/usuarios")
    public String Mostrar(Model model)
    {
        List<Usuario> usuarios = userservice.Mostrar();
        model.addAttribute("usuarios",usuarios);
        return "usuario";
    }

    @GetMapping("/usuarios/nuevo")
    String GuardarMethod(Model model)
    {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("listatipodocumento",tdservice.Mostrar());
        model.addAttribute("listaroles",rolservice.Mostrar());

        return "newusuario";
    }

    @PostMapping("/usuarios/guardar")
    public String Guardar(@Valid Usuario u, BindingResult result, Model model)
    {
        Usuario usuarioexistente = userservice.ValidarUsername(u.getUsername());
        if (usuarioexistente != null)
        {
            result.rejectValue("username","error.username", "Ya existe tal usuario en la Base de Datos");
        }

        if (result.hasErrors())
        {
            model.addAttribute("listatipodocumento",tdservice.Mostrar());
            model.addAttribute("listaroles",rolservice.Mostrar());
            return "newusuario";
        }

        userservice.Guardar(u);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String Editar(@PathVariable Long id, Model model)
    {
        model.addAttribute("listatipodocumento",tdservice.Mostrar());
        model.addAttribute("listaroles",rolservice.Mostrar());

        Optional<Usuario> usuario = userservice.BuscarId(id);
        usuario.ifPresent(o -> model.addAttribute("usuario",o));

        return "updateusuario";
    }

    @PostMapping("/usuarios/actualizar")
    public String EditarMethod(@Valid Usuario u, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("listatipodocumento",tdservice.Mostrar());
            model.addAttribute("listaroles",rolservice.Mostrar());

            return "updateusuario";
        }

        userservice.Guardar(u);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String Eliminar(@PathVariable Long id)
    {
        userservice.Eliminar(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/buscar")
    public String Buscar(Model model, @Param("keyword") String keyword)
    {
        List<Usuario> usuarios = userservice.BuscarUsuario(keyword);

        model.addAttribute("usuarios",usuarios);

        return "usuario";
    }
}
