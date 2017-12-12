package space.indietech.prateleira;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrateleiraService {

	private PrateleiraDao pDao;

	@Autowired
	public PrateleiraService(PrateleiraDao pDao) {
		this.pDao = pDao;
	}

	public PrateleiraBo getBo() {
		new PrateleiraConverter();
		PrateleiraBo bos = PrateleiraConverter.convertDtoToBO(pDao.getListaPrateleira());
		return bos;
	}

	public PrateleiraEntity getPrateleiraPeloId(int id) {
		PrateleiraEntity prateleira = this.pDao.getPrateleiraPeloId(id);
		if (prateleira != null) {
			return prateleira;
		}
		throw new RuntimeException();
	}

	public void setNewPrateleira(PrateleiraEntity prateleira) {
		this.pDao.adicionaPrateleira(prateleira);
	}

	public void deletePrateleira(int id) {
		this.pDao.delete(id);
	}

	
	}

