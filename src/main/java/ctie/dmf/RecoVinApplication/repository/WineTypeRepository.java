package ctie.dmf.RecoVinApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ctie.dmf.RecoVinApplication.entity.WineType;

@Repository
public interface WineTypeRepository extends JpaRepository<WineType, Integer>  {

	@Override
	List<WineType> findAll();
	
	List<WineType> findByWinetypenameContainingIgnoreCase(String winetypename);
	
	WineType findByWinetypeid(int winetypeid);
}
