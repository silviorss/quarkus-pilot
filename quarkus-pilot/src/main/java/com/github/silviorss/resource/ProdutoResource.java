package com.github.silviorss.resource;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.silviorss.dto.ProdutoDTO;
import com.github.silviorss.entity.Produto;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	@GET
	public List<Produto> getAll() {
		return Produto.listAll();
	}
	
	@POST
	@Transactional
	public void postProduto(ProdutoDTO dto) {
		Produto p = new Produto();
		p.setNome(dto.getNome());
		p.setValor(dto.getValor());
		p.persist();
	}
	
	@PUT
	@Path("{id}")
	@Transactional
	public void putProduto(@PathParam("id") Long id, ProdutoDTO dto) {
		Optional<Produto> produtoOpt = Produto.findByIdOptional(id);
		if(produtoOpt.isPresent()) {
			Produto produto = produtoOpt.get();
			produto.setNome(dto.getNome());
			produto.setValor(dto.getValor());
			produto.persist();
		} else {
			throw new NotFoundException();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Transactional
	public void deleteProduto(@PathParam("id") Long id) {
		Optional<Produto> produtoOpt = Produto.findByIdOptional(id);
		produtoOpt.ifPresentOrElse(Produto::delete, () -> {throw new NotFoundException();});
	}
}
