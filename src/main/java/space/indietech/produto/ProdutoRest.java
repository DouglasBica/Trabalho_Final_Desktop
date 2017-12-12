package space.indietech.produto;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/produto")
public class ProdutoRest {

	private ProdutoService produtoService;

	@Autowired
	public ProdutoRest(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> getAll() {
		List<ProdutoDTO> listaDtos = new ProdutoConverter().convertBoToDto(produtoService.getLista());
		return ResponseEntity.ok(listaDtos);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoEntity> getProdutoPeloCodigo(@PathVariable("codigo") int codigo) {
		try {
			return ResponseEntity.ok(this.produtoService.getProdutoPeloCodigo(codigo));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping
	public ResponseEntity<ProdutoEntity> setNewProduto(@RequestBody ProdutoEntity produto) {
		this.produtoService.setNewProduto(produto);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<ProdutoEntity> delete(@PathVariable("codigo") int codigo) {
		this.produtoService.deleteProduto(codigo);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{codigo}")
	public ResponseEntity<ProdutoEntity> post(@PathVariable("codigo") ProdutoEntity codigo) {
		this.produtoService.setNewProduto(codigo);
		return ResponseEntity.noContent().build();
	}
}
