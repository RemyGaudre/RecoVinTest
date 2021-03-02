package ctie.dmf.RecoVinApplication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ctie.dmf.RecoVinApplication.entity.Producer;
import ctie.dmf.RecoVinApplication.repository.ProducerRepository;

@Service
public class ProducerService {
	
	@Autowired
	ProducerRepository producerrepository;
	
	public List<Producer> getAllProducer(){
		List<Producer> list = new ArrayList<>();
		producerrepository.findAll().forEach(list::add);
		return list;
	}
	
	public Producer addProducer(Producer producer) {
		producer = producerrepository.save(producer);
		return producer;
	}
	
	public List<Producer> findProducerByName(String producername){
		return producerrepository.findProducerByProducernameContainingIgnoreCase(producername);
	}
	
	public Producer findProducerByProducerid(int producerid) {
		return producerrepository.findProducerByProducerid(producerid);
	}
}
