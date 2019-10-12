package com.esdras.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.esdras.model.Administrador;

@Repository
public class AdminDao implements DaoGenerico<Administrador> {

	private JdbcTemplate jdbcTemplate;

	public AdminDao(@Autowired DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void salvar(Administrador adm) {
		jdbcTemplate.update(
				"INSERT INTO `andregon_ecommerce`.`administradores` (`cpf`, `nome`, `email`, `emailConfirmado`, `senha`, `nivelAdministrador`, `status`) "
						+ "VALUES ('" + adm.getCpf() + "', '" + adm.getNome() + "', '" + adm.getEmail() + "', '1', '"
						+ adm.getSenha() + "', '1', '1')");
	}

	@Override
	public void excluir(Administrador adm) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Administrador adm) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Administrador> todos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrador> listar(Administrador adm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrador pesquisarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrador pesquisar(Administrador adm) {
		String sql = "SELECT * FROM andregon_ecommerce.administradores where email= '" + adm.getEmail()
				+ "' and senha = '" + adm.getSenha() + "'";

		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Administrador.class));
	}

	@Override
	public List<Administrador> listPorId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Administrador> todosComPaginacao(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
