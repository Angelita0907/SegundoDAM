package service;

import Repository.RetransmisionRepository;
import models.Retransmision;

public class RetransmisionService {
	
	RetransmisionRepository retransmisionRepo;

	public RetransmisionService(RetransmisionRepository retransmisionRepo) {
		super();
		this.retransmisionRepo = new RetransmisionRepository();
	}
	
	public void altaRetransmision(Retransmision r) {
		retransmisionRepo.addRetransmision(r);
	}
	
	public void delRetransmision(Retransmision r) {
		retransmisionRepo.delRetransmision(r);
	}

	public void buscarRetra(Retransmision r) {
		retransmisionRepo.findRetransmision(r);
	}
	
}
