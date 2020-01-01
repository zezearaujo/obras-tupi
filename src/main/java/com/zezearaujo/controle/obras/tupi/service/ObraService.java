package com.zezearaujo.controle.obras.tupi.service;

import java.util.List;

import com.zezearaujo.controle.obras.tupi.domain.Obra;

public interface ObraService {

    void salvar(Obra obra);

    void editar(Obra obra);

    void excluir(Long id);

    Obra buscarPorId(Long id);

    List<Obra> buscarTodos();

	List<Obra> buscarPorCliente(String cliente);

	List<Obra> buscarPorUsuario(Long id);
	

}
