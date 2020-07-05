package com.here.heremaps.application;

import org.springframework.stereotype.Component;

@Component
public class ElectronicCharingVehicle implements HereMapsImpl {

	
	private static final String r = "150";
	private static final String q = "ev-v2";
	private static final String API_KEY = "LKtXL4_3oVTBKBmF3HuvNFSbMR-lDwQ9pLcQZEu-idw";

	@Override
	public String returnUri() {
		
		String uriPath = "r="+r+"&q="+q+"&apiKey="+API_KEY;
		
		return uriPath;
	}
	
}
