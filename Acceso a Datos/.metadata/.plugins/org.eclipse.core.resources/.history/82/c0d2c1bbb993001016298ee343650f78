package Repository;

import java.util.ArrayList;
import java.util.List;

import models.Canal;

public class CanalRepository {
	
	private List<Canal> canales;
	
	public CanalRepository() {
		super();
		this.canales = new ArrayList<Canal>();
	}

	public void addCanal (Canal c){
		canales.add(c);
	}
	
	public void delCanal (Canal c) {
		canales.remove(c);
	}
	
	public Canal findCanal (Canal c) {
		Canal found = null;
		
		if(canales.contains(c)) {
			found = c;
		}
		return found;
		
	}

}
