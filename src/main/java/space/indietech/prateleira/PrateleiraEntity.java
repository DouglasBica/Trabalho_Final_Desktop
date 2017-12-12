package space.indietech.prateleira;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class PrateleiraEntity {
	@Entity
	@Table(name = "prateleira")
	public class ProdutoEntity {

		@Id
		@Column(name = "id")
		@GeneratedValue
		private int id;

		@Column(name = "produto")
		private String produto;

		@Column(name = "quantidade")
		private String quantidade;

		@Column(name = "statusProduto")
		private String statusProduto;

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

		public String getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(String quantidade) {
			this.quantidade = quantidade;
		}

		public String getStatusProduto() {
			return statusProduto;
		}

		public void setStatusProduto(String statusProduto) {
			this.statusProduto = statusProduto;
		}

	}

}
