package com.esdras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.esdras.model.Administrador;
import com.esdras.repository.DaoGenerico;

@Service
public class AdminService extends GenericService<Administrador> {

	@Autowired
	public AdminService(@Qualifier("adminDao") DaoGenerico<Administrador> daoGenerico) {
		super(daoGenerico);
	}

}
