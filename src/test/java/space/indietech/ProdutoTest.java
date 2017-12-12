package space.indietech;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProdutoTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void Produto() throws Exception {
		criaProduto();
		getProduto();
		updateProduto();
		deletarProduto();
		getListaProduto();
		getProdutoComPreco();
		getProdutoPorCodigo();
		ProdutoAtualizado();
		getListaProdutoVazia();

	}

	private void criaProduto() throws Exception {
		String location = "/produto/";

		String json = "{\"codigo\":58941 ," + "\"nome\":\"Lustre\" ,"
				+ "\"descricao\":\"Lustre Tranparente de 8 bracos\"," + "\"fabricante\":\"Mantra\" ,"
				+ "\"preco\": 8.800}";

		mockMvc.perform(put(location).header("Content-Type", "application/json").content(json).header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMTowNTowMS44OTgiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.fxCXPZ-ty5Glrr0vcEW55NepTl9XJUD_XxPGK_IrM0M"))
				.andExpect(status().is2xxSuccessful());
	}

	private void getProduto() throws Exception {
		String location = "/produto/58941";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMTowNTowMS44OTgiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.fxCXPZ-ty5Glrr0vcEW55NepTl9XJUD_XxPGK_IrM0M"))
				.andExpect(status().is2xxSuccessful())

				.andExpect(jsonPath("$.codigo").value(58941)).andExpect(jsonPath("$.nome").value("Lustre"))
				.andExpect(jsonPath("$.descricao").value("Lustre Tranparente de 8 bracos"))
				.andExpect(jsonPath("$.fabricante").value("Mantra")).andExpect(jsonPath("$.preco").value(8.0));

	}

	private void updateProduto() throws Exception {
		String location = "/produto";

		String json = "{\"codigo\":\"58941\" ," + "\"nome\":\"Lustre\" ,"
				+ "\"descricao\":\"Lustre Tranparente de 8 bracos\"," + "\"fabricante\":\"Mantra\","
				+ "\"preco\":\"5.985\"}";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMTowNTowMS44OTgiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.fxCXPZ-ty5Glrr0vcEW55NepTl9XJUD_XxPGK_IrM0M"))
				.andExpect(status().is2xxSuccessful());

	}

	private void ProdutoAtualizado() throws Exception {
		String location = "/produto/58941";

		String json = "{\"codigo\":\"58941\" ," + "\"nome\":\"Lustre\" ," + "\"descricao\":\"Lustre cor canela\","
				+ "\"fabricante\":\"Mantra\"," + "\"preco\":\"5.985\"}";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMTowNTowMS44OTgiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.fxCXPZ-ty5Glrr0vcEW55NepTl9XJUD_XxPGK_IrM0M"))
				.andExpect(status().is2xxSuccessful());

	}

	private void deletarProduto() throws Exception {
		String location = "/produto/58941";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMTowNTowMS44OTgiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.fxCXPZ-ty5Glrr0vcEW55NepTl9XJUD_XxPGK_IrM0M"))
				.andExpect(status().is2xxSuccessful());

	}

	private void getListaProduto() throws Exception {
		String location = "/produto";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMTowNTowMS44OTgiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.fxCXPZ-ty5Glrr0vcEW55NepTl9XJUD_XxPGK_IrM0M"))
				.andExpect(status().is2xxSuccessful());

	}

	private void getProdutoComPreco() throws Exception {
		String location = "/produto/58941/";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMTowNTowMS44OTgiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.fxCXPZ-ty5Glrr0vcEW55NepTl9XJUD_XxPGK_IrM0M"))
				.andExpect(status().is2xxSuccessful())

				.andExpect(jsonPath("$.codigo").value(58941)).andExpect(jsonPath("$.nome").value("Lustre"))
				.andExpect(jsonPath("$.descricao").value("Lustre Tranparente de 8 bracos"))
				.andExpect(jsonPath("$.fabricante").value("Mantra")).andExpect(jsonPath("$.preco").value(8.0));

	}

	private void getProdutoPorCodigo() throws Exception {
		String location = "/produto/58941";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMTowNTowMS44OTgiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.fxCXPZ-ty5Glrr0vcEW55NepTl9XJUD_XxPGK_IrM0M"))
				.andExpect(status().is2xxSuccessful())

				.andExpect(jsonPath("$.codigo").value(58941)).andExpect(jsonPath("$.nome").value("Lustre"))
				.andExpect(jsonPath("$.descricao").value("Lustre Tranparente de 8 bracos"))
				.andExpect(jsonPath("$.fabricante").value("Mantra")).andExpect(jsonPath("$.preco").value(8.0));

	}

	private void getListaProdutoVazia() throws Exception {
		String location = "/produto";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMTowNTowMS44OTgiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.fxCXPZ-ty5Glrr0vcEW55NepTl9XJUD_XxPGK_IrM0M"))
				.andExpect(status().is2xxSuccessful());

	}

}
