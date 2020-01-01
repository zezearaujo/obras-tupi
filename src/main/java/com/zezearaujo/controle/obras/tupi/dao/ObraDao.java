package com.zezearaujo.controle.obras.tupi.dao;

import java.util.List;

import com.zezearaujo.controle.obras.tupi.domain.Obra;

public interface ObraDao {
    
	void save(Obra obra);

    void update(Obra obra);

    void delete(Long id);

    Obra findById(Long id);

    List<Obra> findAll();
    
    List<Obra> findByCliente(String cliente);

	List<Obra> findByUsuarioId(Long id);


}
