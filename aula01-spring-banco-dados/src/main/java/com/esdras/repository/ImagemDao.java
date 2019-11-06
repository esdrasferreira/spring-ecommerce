package com.esdras.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.esdras.model.Imagem;

@Repository
public class ImagemDao implements DaoGenerico<Imagem> {

	private JdbcTemplate jdbcTemplate;

	public ImagemDao(@Autowired DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addProdutoComImagem(String produto, int id, String imagem) {

		jdbcTemplate.update(
				"INSERT INTO `produtos` (`id_produto`, `produto`, `usuariofk`, `imagem`) VALUES (NULL, ?, ?,?)",
				produto, id, imagem);

	}

	public void addImagemAoProduto(String imagem, int id) {
		jdbcTemplate.update(
				"UPDATE `produtos` SET `imagem` = '" + imagem + "' WHERE `produtos`.`id_produto` = '" + id + "'");
	}

	@Override
	public void salvar(Imagem imagem) {
		jdbcTemplate.update("INSERT INTO `andregon_ecommerce`.`imagens` (`produtoId`, `nome`) VALUES ('"
				+ imagem.getProdutoid() + "', '" + imagem.getNome() + "')");

	}

	@Override
	public void excluir(Imagem imagem) {
		jdbcTemplate.update("DELETE FROM andregon_ecommerce.imagens WHERE imagemId = '" + imagem.getImagemid() + "'");

	}

	@Override
	public void atualizar(Imagem imagem) {
		jdbcTemplate.update("");

	}

	@Override
	public List<Imagem> todos() {
		String sql = "SELECT * FROM andregon_ecommerce.imagens";

		List<Imagem> imagens = jdbcTemplate.query(sql, new RowMapper<Imagem>() {

			public Imagem mapRow(ResultSet rs, int rowNum) throws SQLException {
				Imagem imagem = new Imagem(rs.getInt(1), rs.getInt(2), rs.getString(3));
				return imagem;
			}
		});

		return imagens;
	}

	@Override
	public List<Imagem> listar(Imagem imagem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Imagem pesquisarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Imagem pesquisar(Imagem entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Imagem> listPorId(int id) throws Exception {
		String sql = "SELECT * FROM andregon_ecommerce.imagens\n" + "where andregon_ecommerce.imagens.produtoId = '"
				+ id + "' ";
		List<Imagem> imagens = jdbcTemplate.query(sql, new RowMapper<Imagem>() {

			public Imagem mapRow(ResultSet rs, int rowNum) throws SQLException {
				Imagem imagem = new Imagem(rs.getInt(1), rs.getInt(2), rs.getString(3));
				return imagem;
			}
		});
		return imagens;
	}

	@Override
	public Page<Imagem> todosComPaginacao(Pageable pageable) {
		String rowCountSql = "SELECT count(1) AS total from andregon_ecommerce.imagens";

		int total = jdbcTemplate.queryForObject(rowCountSql, (rs, numRows) -> rs.getInt(1));

		String sql = "select  * from andregon_ecommerce.imagens order by andregon_ecommerce.imagens.produtoId desc limit "
				+ pageable.getPageSize() + " " + "offset " + pageable.getOffset();

		List<Imagem> imagens = jdbcTemplate.query(sql, new RowMapper<Imagem>() {
			public Imagem mapRow(ResultSet rs, int rowNum) throws SQLException {

				Imagem imagem = new Imagem(rs.getInt(1), rs.getInt(2), rs.getString(3));

				return imagem;
			}
		});

		return new PageImpl<>(imagens, pageable, total);
	}

	@Override
	public List<Imagem> listarPorCategoria(int categoriaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
