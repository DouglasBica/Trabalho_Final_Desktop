package space.indietech.produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoConverter {

	public List<ProdutoBo> convertEntityToBo(List<ProdutoEntity> entities) {
		List<ProdutoBo> bos = new ArrayList<ProdutoBo>();
		for (ProdutoEntity entity : entities) {

			ProdutoBo bo = new ProdutoBo();

			bo.setCodigo(entity.getCodigo());
			bo.setNome(entity.getNome());
			bo.setDescricao(entity.getDescricao());
			bo.setFabricante(entity.getFabricante());
			bo.setPreco(entity.getPreco());

			bos.add(bo);
		}
		return bos;
	}

	public List<ProdutoDTO> convertBoToDto(List<ProdutoBo> bos) {
		List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();
		for (ProdutoBo bo : bos) {

			ProdutoDTO dto = new ProdutoDTO();

			dto.setCodigo(bo.getCodigo());
			dto.setNome(bo.getNome());
			dto.setDescricao(bo.getDescricao());
			dto.setFabricante(bo.getFabricante());
			dto.setPreco(bo.getPreco());

			dtos.add(dto);
		}
		return dtos;
	}

}
