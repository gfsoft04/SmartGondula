package br.com.gfsoft.smartgondula.service;

import br.com.gfsoft.smartgondula.service.Service;

public class Service {
	
private static final Service SERVICE = new Service();
	

	public Service getInstancia(){
		return SERVICE;
	}
	
}
