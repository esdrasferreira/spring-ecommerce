package com.esdras.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.esdras.model.Cliente;

@Repository
public class ClienteDao implements DaoGenerico<Cliente> {

	private JdbcTemplate jdbcTemplate;

	public ClienteDao(@Autowired DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void salvar(Cliente cliente) {
		jdbcTemplate.update(
				"INSERT INTO `andregon_ecommerce`.`clientes` (`cpf`, `nome`, `email`, `emailConfirmado`, `senha`, `status`)"
						+ " VALUES ('" + cliente.getCpf() + "', '" + cliente.getNome() + "', '" + cliente.getEmail()
						+ "','1' ,'" + cliente.getSenha() + "', '1')");

	}

	@Override
	public void excluir(Cliente cliente) {
		jdbcTemplate.update("");

	}

	@Override
	public void atualizar(Cliente cliente) {
		jdbcTemplate.update("");

	}

	@Override
	public List<Cliente> todos() {

		return null;
	}

	@Override
	public List<Cliente> listar(Cliente cliente) {
		return null;

	}

	@Override
	public Cliente pesquisarPorId(int id) {
		String sql = "SELECT * FROM andregon_ecommerce.clientes where clienteId = '" + id + "'";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Cliente.class));
	}

	@Override
	public Cliente pesquisar(Cliente cliente) {

		String sql = "SELECT * FROM andregon_ecommerce.clientes where email='" + cliente.getEmail() + "' and senha = '"
				+ cliente.getSenha() + "'";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Cliente.class));
	}

	@Override
	public List<Cliente> listPorId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Cliente> todosComPaginacao(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
