package space.indietech.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoService {

	private ProdutoDao pDao;

	@Autowired
	public ProdutoService(ProdutoDao pDao) {
		this.pDao = pDao;
	}

	public List<ProdutoBo> getLista() {
		List<ProdutoBo> bos = new ProdutoConverter().convertEntityToBo(pDao.getListaProduto());
		return bos;
	}

	public ProdutoEntity getProdutoPeloCodigo(int codigo) {
		ProdutoEntity produto = this.pDao.getProdutoPeloCodigo(codigo);
		if (produto != null) {
			return produto;
		}
		throw new RuntimeException();
	}

	public void setNewProduto(ProdutoEntity produto) {
		this.pDao.adicionaProduto(produto);
	}

	public void deleteProduto(int codigo) {
		this.pDao.delete(codigo);
	}

}
