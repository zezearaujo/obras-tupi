package com.zezearaujo.controle.obras.tupi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zezearaujo.controle.obras.tupi.domain.Obra;

@Repository
public class ObraDaoImpl extends AbstractDao<Obra, Long> implements ObraDao {

	public List<Obra> findByCliente(String cliente) {
		
		return createQuery("select o from Obra o where o.cliente like concat('%',?1,'%') ", cliente);
	}

	@Override
	public List<Obra> findByUsuarioId(Long id) {
		
		return createQuery("select o from Obra o where o.usuario.id = ?1", id);
	}





	
}
