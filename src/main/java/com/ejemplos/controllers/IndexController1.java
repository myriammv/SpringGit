package com.ejemplos.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ejemplos.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController1 {
	
	@GetMapping("/index")
	public String index() {
		return ("index");
	}
	
	//pasar datos del controlador a la vista con la interfaz model
	@GetMapping("/index2")
	public String index2(Model model) {
		model.addAttribute("titulo","hola Spring: pasar datos del controlador a la vista con la interfaz Model");
		return ("index2");
	}
	
	
	@GetMapping("/index3")
	public String index3(ModelMap model) {
		model.addAttribute("titulo","hola Spring: pasar datos del controlador a la vista con la clase ModelMap");
		return ("index2");
	}
	
	
	@GetMapping("/index4")
	public String index4(Map<String, Object> map) {
		map.put("titulo","hola Spring: pasar datos del controlador a la vista con la interfaz Map");
		return ("index2");
	}
	
	@GetMapping("/index5")
	public ModelAndView index5(ModelAndView mv) {
		mv.addObject("titulo","hola Spring: pasar datos del controlador a la vista con ModelAndView");
		mv.setViewName("index2");
		return mv;
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("José Luis");
		usuario.setApellido("Rus Rus");
//		usuario.setEmail("rrjos3@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@GetMapping("/listar1")
	public String listar1(Model model) {
//		List<Usuario> usuarios = new ArrayList<Usuario>();
		model.addAttribute("titulo", "Listado de usuarios");
//		model.addAttribute("usuarios", usuarios);
		
		return "listar";
		
	}
	
	@GetMapping("/listar2")
	public String listar2(Model model) {
//		List<Usuario> usuarios = new ArrayList<Usuario>();
//		Usuario u1 = new Usuario("Pepe","Rodriguez","pepe@correo.es");
//		Usuario u2 = new Usuario("Manolo","Gómez","manolo@correo.es");
//		usuarios.add(u1);
//		usuarios.add(u2);
		model.addAttribute("titulo", "Listado de usuarios");
//		model.addAttribute("usuarios", usuarios);
		
		return "listar";
		
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		Usuario u1 = new Usuario("Pepe","Rodriguez","pepe@correo.es");
		Usuario u2 = new Usuario("Manolo","Gómez","manolo@correo.es");
		List<Usuario> usuarios = Arrays.asList(u1, u2);
		
		return usuarios;
	}
	
	
	
	
	
}
