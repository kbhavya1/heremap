package com.here.heremaps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.here.heremaps.application.OnStreetParking;
import com.here.heremaps.restClient.RestClient;

@SpringBootApplication
public class HeremapsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HeremapsApplication.class);
	
	//String place = "London";
	//get long & lat funtionConvertToLat&Long
	
//	@Autowired
	private static RestClient restClient;
//	
//	@Autowired
	private static OnStreetParking onStreetParking;
	
	
	//ob1 = new OnSteet
	//ob2 = new OffStreet
	//ob1 = new EV
	//t1 -> ob1.function();
	//t2->ob2.function();
	//t3 ->ob3.function();
	
	private static final String baseUriPath = "discover.search.hereapi.com/v1/discover?";
	private static final String at = "23.3441,85.3096";
	private static final String circle = "42.3399,-71.05493";

	public static void main(String[] args) {
		SpringApplication.run(HeremapsApplication.class, args);
		
		log.info("comming in the rest client");
		
		String completeUriPath = baseUriPath+"at="+at+"&circle="+circle;
		log.info("base path {}",completeUriPath);
		String response = restClient.queryRestEndpoints(onStreetParking, completeUriPath, true);
		
//		log.info("string response is {}",response);
		
	}

	@Autowired
	public void setRestClient(RestClient restClient){
		HeremapsApplication.restClient = restClient;
	}
	
	@Autowired
	public void setOnSteetClient(OnStreetParking onStreetParking) {
		HeremapsApplication.onStreetParking = onStreetParking;
	}
	
}
