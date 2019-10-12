package com.esdras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.esdras.model.Cliente;
import com.esdras.repository.DaoGenerico;

@Service
public class ClienteService extends GenericService<Cliente> {

	@Autowired
	public ClienteService(@Qualifier("clienteDao") DaoGenerico<Cliente> daoGenerico) {
		super(daoGenerico);
	}

}
