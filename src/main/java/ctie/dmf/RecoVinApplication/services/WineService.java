package ctie.dmf.RecoVinApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ctie.dmf.RecoVinApplication.entity.Wine;
import ctie.dmf.RecoVinApplication.repository.WineRepository;

@Service
public class WineService {

	@Autowired
	WineRepository winerepository;
	
	public List<Wine> getAllWines(){
		return winerepository.findAll();
	}
	
}
