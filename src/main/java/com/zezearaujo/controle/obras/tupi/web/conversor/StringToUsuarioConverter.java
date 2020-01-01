package com.zezearaujo.controle.obras.tupi.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.zezearaujo.controle.obras.tupi.domain.Usuario;
import com.zezearaujo.controle.obras.tupi.service.UsuarioService;

@Component
public class StringToUsuarioConverter implements Converter<String, Usuario> {
	
	@Autowired
	private UsuarioService service;

	@Override
	public Usuario convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
