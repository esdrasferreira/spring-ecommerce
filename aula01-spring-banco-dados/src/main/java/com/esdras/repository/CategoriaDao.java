package com.esdras.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.esdras.model.Categoria;

@Repository
public class CategoriaDao implements DaoGenerico<Categoria> {

	private JdbcTemplate jdbcTemplate;

	public CategoriaDao(@Autowired DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void salvar(Categoria categoria) {
		jdbcTemplate.update("INSERT INTO `andregon_ecommerce`.`categorias` (`nomecategoria`) VALUES (?)",
				categoria.getNome());

	}

	@Override
	public void excluir(Categoria categoria) {
		jdbcTemplate.update("");

	}

	@Override
	public void atualizar(Categoria categoria) {
		jdbcTemplate.update("");

	}

	@Override
	public List<Categoria> todos() {
		String sql = "SELECT * FROM andregon_ecommerce.categorias";

		List<Categoria> categorias = jdbcTemplate.query(sql, new RowMapper<Categoria>() {
			public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
				Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
				return categoria;
			}

		});
		return categorias;
	}

	@Override
	public List<Categoria> listar(Categoria categoria) {
		String sql = "";
		List<Categoria> categorias = jdbcTemplate.query(sql, new RowMapper<Categoria>() {

			public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {

				Categoria categoria = new Categoria();
				categoria.setCategoriaid(rs.getInt(1));
				categoria.setNome(rs.getString(2));

				return categoria;

			}
		});

		return categorias;

	}

	@Override
	public Categoria pesquisarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria pesquisar(Categoria categoria) {

		String sql = "SELECT * FROM andregon_ecommerce.categorias where nomecategoria ='" + categoria.getNome() + "'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Categoria>() {
			public Categoria extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
					return categoria;
				}
				return null;
			}

		});
	}

	@Override
	public List<Categoria> listPorId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Categoria> todosComPaginacao(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
