
package space.indietech;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
public class PrateleiraTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void Produto() throws Exception {
		creatProduto();

	}

	private void creatProduto() throws Exception {
		String location = "/prateleira/";

		String json = "{\"id\":01 ," + "\"produto\":\"uyyyy\" ," + "\"quantidade\":\"10\","
				+ "\"statusProduto\":\"aaaaa\" }";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0xMSAyMTowNTowMS44OTgiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.fxCXPZ-ty5Glrr0vcEW55NepTl9XJUD_XxPGK_IrM0M"))
				.andExpect(status().is2xxSuccessful())

				.andExpect(status().isOk()).andExpect(jsonPath("$.id").value(01))
				.andExpect(jsonPath("$.produto").value("uyyyy")).andExpect(jsonPath("$.quantidade").value(10))
				.andExpect(jsonPath("$.statusProduto").value("aaaaa"));
	}

}
