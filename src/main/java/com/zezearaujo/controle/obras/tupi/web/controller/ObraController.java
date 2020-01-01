package com.zezearaujo.controle.obras.tupi.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zezearaujo.controle.obras.tupi.domain.Obra;
import com.zezearaujo.controle.obras.tupi.domain.SituacaoObra;
import com.zezearaujo.controle.obras.tupi.domain.UF;
import com.zezearaujo.controle.obras.tupi.domain.Usuario;
import com.zezearaujo.controle.obras.tupi.service.ObraService;
import com.zezearaujo.controle.obras.tupi.service.UsuarioService;

@Controller
@RequestMapping("/obras")
public class ObraController {
	
	@Autowired
	private ObraService obraService;
	@Autowired
	private UsuarioService usuarioService;
	
	//@InitBinder
	//public void initBinder(WebDataBinder binder) {
	//	binder.addValidators(new FuncionarioValidator());
	//}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Obra obra) {
		return "obra/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("obras", obraService.buscarTodos());
		return "obra/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Obra obra, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "obra/cadastro";
		}
		
		obraService.salvar(obra);
		attr.addFlashAttribute("success", "Obra inserida com sucesso.");
		return "redirect:/obras/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("obra", obraService.buscarPorId(id));
		return "obra/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Obra obra, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "obra/cadastro";
		}
		
		obraService.editar(obra);
		attr.addFlashAttribute("success", "Obra editada com sucesso.");
		return "redirect:/obras/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		obraService.excluir(id);
		attr.addFlashAttribute("success", "Obra removida com sucesso.");
		return "redirect:/obras/listar";
	}	
	
	@GetMapping("/buscar/cliente")
	public String getPorCliente(@RequestParam("cliente") String cliente, ModelMap model) {		
		model.addAttribute("obras", obraService.buscarPorCliente(cliente));
		return "obra/lista";
	}
	
	@GetMapping("/buscar/usuario")
	public String getPorUsuario(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("obras", obraService.buscarPorUsuario(id));
		return "obra/lista";
	}		
	
	@ModelAttribute("usuarios")
	public List<Usuario> getUsuarios() {
		return usuarioService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
	@ModelAttribute("situacoes")
	public SituacaoObra[] getSituacoes() {
		return SituacaoObra.values();
	}
}
