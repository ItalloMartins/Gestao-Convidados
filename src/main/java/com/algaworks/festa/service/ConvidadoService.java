package com.algaworks.festa.service;

import java.util.List;

import com.algaworks.festa.model.Convidado;

public interface ConvidadoService {

	List<Convidado> findAll();
	Convidado findById(long id);
	
	
}
