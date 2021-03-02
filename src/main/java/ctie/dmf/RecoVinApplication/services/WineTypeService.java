package ctie.dmf.RecoVinApplication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ctie.dmf.RecoVinApplication.entity.WineType;
import ctie.dmf.RecoVinApplication.repository.WineTypeRepository;

@Service
public class WineTypeService {

	@Autowired
	WineTypeRepository winetyperepository;
	
	public List<WineType> getAllWineType(){
		List<WineType> list = new ArrayList<>();
		winetyperepository.findAll().forEach(list::add);
		return list;
	}
	
	public WineType addWineType(WineType winetype) {
		winetype = winetyperepository.save(winetype);
		return winetype;
	}
	
	public List<WineType> findWineTypebyName(String winetypename) {
		List<WineType> winetypelist = winetyperepository.findByWinetypenameContainingIgnoreCase(winetypename);
		return winetypelist;
	}
	
	public WineType findWineTypeById(int winetypeid) {
		return winetyperepository.findByWinetypeid(winetypeid);
	}
	
}
