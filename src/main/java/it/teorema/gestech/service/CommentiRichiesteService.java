package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.CommentiRichieste;

public interface CommentiRichiesteService extends JpaRepository <CommentiRichieste, Integer>
{

	@Query("select c.data, r.nomeCognome, c.note "
			+ "from CommentiRichieste c, Richieste r "
			+ "where r.id = c.idRisorsa and r.id = :idRisorsa "
			+ "order by c.data desc")
	abstract
	List stampaCommentiRichieste(int idRisorsa);

	@Query("from CommentiRichieste "
			+ "where id = :idCommento")
	abstract
	List<CommentiRichieste> findById(int idCommento);
}
