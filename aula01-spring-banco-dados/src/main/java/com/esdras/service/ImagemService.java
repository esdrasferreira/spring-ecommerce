package com.esdras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.esdras.model.Imagem;
import com.esdras.repository.DaoGenerico;

@Service
public class ImagemService extends GenericService<Imagem> {

	@Autowired
	public ImagemService(@Qualifier("imagemDao") DaoGenerico<Imagem> daoGenerico) {
		super(daoGenerico);
	}

}
