package com.fatec.produto.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.produto.model.Produto;
import com.fatec.produto.model.ProdutoRepository;
@SpringBootTest
class Req01CadastrarProdutoTeste {
	@Autowired
	ProdutoRepository repository;
	@Test
	void ct01_cadastrar_produto_com_sucesso() {
		//dado que nao existe nennhum registro cadastrado
		repository.deleteAll();
		//quando o usuario cadastra um produto
		Produto produto = new Produto();
		produto.setDescricao("Eletrobomba 110v p/ maquina de lavar");
		produto.setCategoria("maquina de lavar");
		produto.setCusto(51.66);
		produto.setQuantidadeEstoque(10);
		Produto p = repository.save(produto);
		//entao o produto fica disponivel para consulta
		assertEquals(1,repository.count());
		assertNotNull(p);
	}
	@Test
	void ct02_cadastrar_produto_com_descricao_invalida(){
		try {
			Produto produto = new Produto();
			produto.setDescricao("");
			fail("deveria disparar uma exception");
		} catch (IllegalArgumentException e) {
			assertEquals("a descrição não pode estar em branco!", e.getMessage());
		}
	}

}
