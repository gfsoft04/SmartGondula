package br.com.gfsoft.smartgondula.persistence;

import java.util.Set;

import br.com.gfsoft.smartgondula.model.Lcd;

public interface IPersistenceLcd {
	
	public boolean insert(Lcd lcd);
	public boolean delete(Lcd lcd);
	public boolean update(Lcd lcd);
	public Lcd selectLcd(int codigo);
	public Set<Lcd> selectLcds();

}
