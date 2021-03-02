package ctie.dmf.RecoVinApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ctie.dmf.RecoVinApplication.entity.Producer;
import ctie.dmf.RecoVinApplication.entity.Wine;
import ctie.dmf.RecoVinApplication.entity.WineType;
import ctie.dmf.RecoVinApplication.models.AuthenticationRequest;
import ctie.dmf.RecoVinApplication.models.AuthenticationResponse;
import ctie.dmf.RecoVinApplication.security.MyUserDetailsService;
import ctie.dmf.RecoVinApplication.services.ProducerService;
import ctie.dmf.RecoVinApplication.services.WineService;
import ctie.dmf.RecoVinApplication.services.WineTypeService;
import ctie.dmf.RecoVinApplication.util.JwtUtil;

/**
 * @author rgaudre
 *
 */
@RestController
public class API {
	
	/******************** *****************/
	
	/**
	 * API Authentication (necessary except for getting data)
	 */
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthentiticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
				);
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	/**
	 * WineType service API
	 */	

	@Autowired
	private WineTypeService winetypeservice;
	
	//Get all wine types (Accessible by all)
	@GetMapping(path = "/getWineTypes")
	List<WineType> getWineTypes(){
		return winetypeservice.getAllWineType();
	}
	
	//Get all wine types by name (Accessible by all)
	@RequestMapping(value="/getWineTypesByName", method=RequestMethod.GET)
	List<WineType> getWineTypes(@RequestBody WineType winetype){
		System.out.println("Recherche du typevin :"+winetype);
		return winetypeservice.findWineTypebyName(winetype.getWinetypename());
	}
	
	//Get all wine types by name (Accessible by all)
	@RequestMapping(value="/getWineTypeById", method=RequestMethod.GET)
	WineType getWineTypesById(@RequestParam(name = "winetypeid") int winetypeid){
		System.out.println("Recherche du typevin :"+winetypeid);
		return winetypeservice.findWineTypeById(winetypeid);
	}
	
	//Insert a new wine type (Accessible by admin)
	@RequestMapping(value="/newWineType", method=RequestMethod.POST)
	  public ResponseEntity<WineType> createWineType(@RequestBody WineType winetype) {
		try {
		      WineType _winetype = winetypeservice.addWineType(winetype);
		      return new ResponseEntity<>(_winetype, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	
	/**
	 * Producer service API
	 */	
	
	@Autowired
	private ProducerService producerservice;
	
	//Get all producers (Accessible by all)
	@GetMapping(path = "/getProducers")
	List<Producer> getProducers(){
		return producerservice.getAllProducer();
	}
	
	//Get all producers by name (Accessible by all)
	@RequestMapping(value="/getProducersByName", method=RequestMethod.GET)
	List<Producer> getProducers(@RequestParam(name = "producername") String producername){
		System.out.println("Finding producer by name :"+producername);
		return producerservice.findProducerByName(producername);
	}
	
	//Get all producers by Id (Accessible by all)
	@RequestMapping(value="/getProducerById", method=RequestMethod.GET)
	Producer getProducers(@RequestParam(name = "producerid") int producerid){
		System.out.println("Finding producer by name :"+producerid);
		return producerservice.findProducerByProducerid(producerid);
	}
	
	//Insert a new producer (Accessible by admin)
	@RequestMapping(value="/newProducer", method=RequestMethod.POST)
	  public ResponseEntity<Producer> Producer(@RequestBody Producer producer) {
		try {
			Producer _producer = producerservice.addProducer(producer);
		      return new ResponseEntity<>(_producer, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	
	
	/**
	 * Wine service API
	 */
	
	@Autowired
	private WineService wineservice;
	
	//Get all producers (Accessible by all)
	@GetMapping(path = "/getWines")
	List<Wine> getWines(){
		return wineservice.getAllWines();
	}
}
