package com.zezearaujo.controle.obras.tupi.service;

import java.util.List;

import com.zezearaujo.controle.obras.tupi.domain.Usuario;

public interface UsuarioService {

	void salvar(Usuario usuario);
	
	void editar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario buscarPorId(Long id);
	
	List<Usuario> buscarTodos();
	
	boolean usuarioTemObras(Long id);
}
