package space.indietech.prateleira;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prateleira")
public class PrateleiraRest {

	private PrateleiraService prateleiraService;

	@Autowired
	public PrateleiraRest(PrateleiraService prateleiraService) {
		this.prateleiraService = prateleiraService;
	}

	@GetMapping
	public ResponseEntity<PrateleiraDTO> getAll() {

		PrateleiraDTO listaDtos = PrateleiraConverter.convertBoToDTO(prateleiraService.getBo());
		return ResponseEntity.ok(listaDtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PrateleiraEntity> getPrateleiraPeloId(@PathVariable("id") int id) {
		try {
			return ResponseEntity.ok(this.prateleiraService.getPrateleiraPeloId(id));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping
	public ResponseEntity<PrateleiraEntity> setNewPrateleira(@RequestBody PrateleiraEntity prateleira) {
		this.prateleiraService.setNewPrateleira(prateleira);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<PrateleiraEntity> delete(@PathVariable("id") int id) {
		this.prateleiraService.deletePrateleira(id);
		return ResponseEntity.noContent().build();
	}
}
