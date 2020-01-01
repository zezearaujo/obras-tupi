package com.zezearaujo.controle.obras.tupi.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zezearaujo.controle.obras.tupi.domain.Usuario;
import com.zezearaujo.controle.obras.tupi.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;


	@GetMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {
		return "usuario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("usuarios", usuarioService.buscarTodos());
		return "usuario/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Usuario cargo, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "usuario/cadastro";
		}
		
		usuarioService.salvar(cargo);
		attr.addFlashAttribute("success", "Usuario inserido com sucesso.");
		return "redirect:/usuarios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("usuario", usuarioService.buscarPorId(id));
		return "usuario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "usuario/cadastro";
		}	
		
		usuarioService.editar(usuario);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/usuarios/cadastrar";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (usuarioService.usuarioTemObras(id)) {
			attr.addFlashAttribute("fail", "Usuário não excluido. Tem Obra(s) vinculada(s).");
		} else {
			usuarioService.excluir(id);
			attr.addFlashAttribute("success", "Usuario excluido com sucesso.");
		}
		return "redirect:/usuarios/listar";
	}
	

}
