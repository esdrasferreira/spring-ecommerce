package com.esdras.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.esdras.model.Categoria;
import com.esdras.model.Produto;

@Repository
public class ProdutoDaoImp implements DaoGenerico<Produto> {

	private JdbcTemplate jdbcTemplate;

	public ProdutoDaoImp(@Autowired DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void salvar(Produto produto) {

		jdbcTemplate.update(
				"INSERT INTO `andregon_ecommerce`.`produtos` (`categoriaId`, `nomeproduto`, `descricao`, `valor`) VALUES (?, ?, ?, ?)",
				produto.getCategoriaid(), produto.getNome(), produto.getDescricao(), produto.getValor());
	}

	public void atualizar(Produto produto) {

		jdbcTemplate.update("update andregon_ecommerce.produtos \n"
				+ "set andregon_ecommerce.produtos.categoriaId = ?, andregon_ecommerce.produtos.nomeproduto = ?, andregon_ecommerce.produtos.descricao = ?, \n"
				+ "andregon_ecommerce.produtos.valor = ?\n" + "where andregon_ecommerce.produtos.produtoId = ?",
				produto.getCategoriaid(), produto.getNome(), produto.getDescricao(), produto.getValor(),
				produto.getProdutoid());

	}

	public void excluir(Produto produto) {
		jdbcTemplate.update("DELETE FROM andregon_ecommerce.produtos WHERE produtoId = ?", produto.getProdutoid());

	}

	public Produto pesquisarPorId(int id) {
		String sql = "SELECT * FROM produtos WHERE id=" + id;
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Produto.class));

	}

	public List<Produto> todos() {

		String sql = "SELECT andregon_ecommerce.produtos.*, andregon_ecommerce.categorias.* \n"
				+ "FROM andregon_ecommerce.produtos, andregon_ecommerce.categorias \n"
				+ "where produtos.categoriaId = categorias.categoriaId";

		List<Produto> produtos = jdbcTemplate.query(sql, new RowMapper<Produto>() {

			public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {

				Produto produto = new Produto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5));
				produto.setCategoria(new Categoria(rs.getInt(6), rs.getString(7)));

				return produto;

			}
		});

		return produtos;

	}

	@Override
	public Page<Produto> todosComPaginacao(Pageable pageable) {

		String rowCountSql = "SELECT count(1) AS total from andregon_ecommerce.produtos";
		int total = jdbcTemplate.queryForObject(rowCountSql, (rs, numRows) -> rs.getInt(1));

		String sql = "select andregon_ecommerce.produtos.*, andregon_ecommerce.categorias.* from andregon_ecommerce.produtos, andregon_ecommerce.categorias\n"
				+ "where andregon_ecommerce.produtos.categoriaId = andregon_ecommerce.categorias.categoriaId order by andregon_ecommerce.produtos.produtoId desc limit "
				+ pageable.getPageSize() + " " + "offset " + pageable.getOffset();

//		String sql = "SELECT * from produtos " + "LIMIT " + pageable.getPageSize() + " " + "OFFSET "
//				+ pageable.getOffset();

		List<Produto> produtos = jdbcTemplate.query(sql, new RowMapper<Produto>() {

			public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {

				Produto produto = new Produto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5));

				produto.setCategoria(new Categoria(rs.getInt(6), rs.getString(7)));

				return produto;

			}
		});

		return new PageImpl<>(produtos, pageable, total);

	}

	@Override
	public List<Produto> listar(Produto produto) {
		String sql = "SELECT * FROM andregon_ecommerce.produtos WHERE nome LIKE '%'" + produto.getNome() + "'%' ";
		List<Produto> produtos = jdbcTemplate.query(sql, new RowMapper<Produto>() {

			public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {

				Produto produto = new Produto();
				produto.setProdutoid(rs.getInt("produtoid"));
				produto.setCategoriaid(rs.getInt("categoriaid"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));

				return produto;

			}
		});

		return produtos;

	}

	@Override
	public Produto pesquisar(Produto entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listPorId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
