package com.esdras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.esdras.model.Categoria;
import com.esdras.repository.DaoGenerico;

@Service
public class CategoriaService extends GenericService<Categoria> {

	@Autowired
	public CategoriaService(@Qualifier("categoriaDao") DaoGenerico<Categoria> daoGenerico) {
		super(daoGenerico);
	}

}
