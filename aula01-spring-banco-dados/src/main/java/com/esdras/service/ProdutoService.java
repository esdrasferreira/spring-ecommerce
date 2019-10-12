package com.esdras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.esdras.model.Produto;
import com.esdras.repository.DaoGenerico;

@Service
public class ProdutoService extends GenericService<Produto> {

	@Autowired
	public ProdutoService(@Qualifier("produtoDaoImp") DaoGenerico<Produto> daoGenerico) {
		super(daoGenerico);
	}

}
