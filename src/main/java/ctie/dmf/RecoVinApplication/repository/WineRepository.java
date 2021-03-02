package ctie.dmf.RecoVinApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ctie.dmf.RecoVinApplication.entity.Wine;

public interface WineRepository extends JpaRepository<Wine, String> {

	@Override
	List<Wine> findAll();
}
