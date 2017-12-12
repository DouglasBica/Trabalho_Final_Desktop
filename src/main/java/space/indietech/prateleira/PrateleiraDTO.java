package space.indietech.prateleira;

public class PrateleiraDTO {

	private int id;
	private String produto;
	private int quantidade;
	private int statusProduto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getStatusProduto() {
		return statusProduto;
	}

	public void setStatusProduto(int statusProduto) {
		this.statusProduto = statusProduto;
	}

}
