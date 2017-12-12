package space.indietech.prateleira;

import java.util.List;

public class PrateleiraConverter {

	public static PrateleiraBo convertDtoToBO(List<PrateleiraEntity> list) {
		PrateleiraBo bo = new PrateleiraBo();

		bo.setId(bo.getId());
		bo.setProduto(bo.getProduto());
		bo.setQuantidade(bo.getQuantidade());
		bo.setStatusProduto(bo.getStatusProduto());
		return bo;
	}

	public static PrateleiraDTO convertBoToDTO(PrateleiraBo bo) {
		PrateleiraDTO dto = new PrateleiraDTO();
		dto.setId(bo.getId());
		dto.setProduto(bo.getProduto());
		dto.setQuantidade(bo.getQuantidade());
		dto.setStatusProduto(bo.getStatusProduto());
		return dto;
	}
}
