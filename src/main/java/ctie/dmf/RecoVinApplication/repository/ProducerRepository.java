package ctie.dmf.RecoVinApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ctie.dmf.RecoVinApplication.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {

	@Override
	List<Producer> findAll();
	
	List<Producer> findProducerByProducernameContainingIgnoreCase(String producername);
	
	Producer findProducerByProducerid(int producerid);
}
