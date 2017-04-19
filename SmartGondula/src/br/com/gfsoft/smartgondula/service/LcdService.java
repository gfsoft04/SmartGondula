package br.com.gfsoft.smartgondula.service;

import java.util.Set;

import br.com.gfsoft.smartgondula.model.Lcd;
import br.com.gfsoft.smartgondula.persistence.IPersistenceLcd;
import br.com.gfsoft.smartgondula.persistence.PersistenceLcd;

public class LcdService extends Service{
	
	private IPersistenceLcd persistencia;
	
	public LcdService(){
		
		persistencia = new PersistenceLcd();
		
	}
	
	public boolean cadastrar(Lcd lcd){
		return persistencia.insert(lcd);
	}
	
	public boolean deletar(Lcd lcd){
		return persistencia.delete(lcd);
	}
	
	public boolean atualizar(Lcd lcd){
		return persistencia.update(lcd);
	}
	
	public Lcd buscar(int codigo) {
		return persistencia.selectLcd(codigo);
	}
	
	public Set<Lcd> listar(){
		return persistencia.selectLcds();
	}
	
	public Set<Lcd> filtrar(int codigo){
		return persistencia.filtrarLcds(codigo);
	}

}
