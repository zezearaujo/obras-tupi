package com.zezearaujo.controle.obras.tupi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zezearaujo.controle.obras.tupi.dao.ObraDao;
import com.zezearaujo.controle.obras.tupi.domain.Obra;

@Service
@Transactional(readOnly = true)
public class ObraServiceImpl implements ObraService {
	
	@Autowired
	private ObraDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Obra obra) {
		dao.save(obra);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Obra obra) {
		dao.update(obra);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Obra buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Obra> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public List<Obra> buscarPorCliente(String cliente) {
		
		return dao.findByCliente(cliente);
	}

	@Override
	public List<Obra> buscarPorUsuario(Long id) {
		
		return dao.findByUsuarioId(id);
	}


}
