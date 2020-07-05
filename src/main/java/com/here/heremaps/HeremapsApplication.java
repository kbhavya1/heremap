package com.here.heremaps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.here.heremaps.application.ElectronicCharingVehicle;
import com.here.heremaps.application.OffsetParking;
import com.here.heremaps.application.OnStreetParking;
import com.here.heremaps.restClient.RestClient;

@SpringBootApplication
public class HeremapsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HeremapsApplication.class);
	
	private static RestClient restClient;
	
	private static OnStreetParking onStreetParking;
	
	private static OffsetParking offStreetParking;
	
	private static ElectronicCharingVehicle evParking;

	private static final String baseUriPath = "discover.search.hereapi.com/v1/discover?";
	private static final String at = "23.3441,85.3096";
	private static final String circle = "42.3399,-71.05493";
	
	private static final String completeUriPath = baseUriPath+"at="+at+"&circle="+circle;

	public static void main(String[] args) {
		SpringApplication.run(HeremapsApplication.class, args);
		
		log.info("starting thread");
		
		Thread onStreet = new Thread(()->{
			String response = restClient.queryRestEndpoints(onStreetParking, completeUriPath, true);
			log.info("on street response {}",response);
		});
		
		Thread offStreet = new Thread(()->{
			String response = restClient.queryRestEndpoints(offStreetParking, completeUriPath, true);
			log.info("on street response {}",response);
		});
		
		Thread evCharging = new Thread(()->{
			String response = restClient.queryRestEndpoints(evParking, completeUriPath, true);
			log.info("on street response {}",response);
		});
		
		onStreet.start();
		offStreet.start();
		evCharging.start();
		
	}

	@Autowired
	public void setRestClient(RestClient restClient){
		HeremapsApplication.restClient = restClient;
	}
	
	@Autowired
	public void setOnSteetClient(OnStreetParking onStreetParking) {
		HeremapsApplication.onStreetParking = onStreetParking;
	}
	
	@Autowired
	public void setOffnSteetClient(OffsetParking offStreetParking) {
		HeremapsApplication.offStreetParking = offStreetParking;
	}
	
	@Autowired
	public void setEvClient(ElectronicCharingVehicle evParking) {
		HeremapsApplication.evParking = evParking;
	}
	
}
