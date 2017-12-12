package space.indietech.prateleira;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrateleiraDao {

	private EntityManager em;

	@Autowired
	public PrateleiraDao(EntityManager em) {
		super();
		this.em = em;
	}

	@Transactional
	public void adicionaPrateleira(PrateleiraEntity prateleira) {
		em.merge(prateleira);
	}

	public List<PrateleiraEntity> getListaPrateleira() {
		List<PrateleiraEntity> prateleira = em.createQuery("from PrateleiraEntity").getResultList();
		return prateleira;
	}

	@Transactional
	public void delete(int id) {
		PrateleiraEntity prateleira = new PrateleiraEntity();
		prateleira = em.find(PrateleiraEntity.class, id);
		if (prateleira != null) {
			em.remove(prateleira);
		}

	}

	public PrateleiraEntity getPrateleiraPeloId(int id) {
		return em.find(PrateleiraEntity.class, id);
	}
}
