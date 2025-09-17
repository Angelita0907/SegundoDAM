package service;

import Repository.CanalRepository;
import models.Canal;

public class CanalService {
	
	CanalRepository canalRepo;

	public CanalService(CanalRepository canalRepo) {
		super();
		this.canalRepo = new CanalRepository();
	}
	
	public void altaCanal(Canal c) {
		canalRepo.addCanal(c);
	}
	
	public void borrarCanal(Canal c) {
		canalRepo.delCanal(c);
	}

	public void findCanal(Canal c) {
		canalRepo.findCanal(c);
	}
	
}
