package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Producers;

public interface IProducerService {
	List<Producers> getAllProducers();
	Producers addProducer(Producers transientProducer);
	Optional<Producers> getProducerDetailsbyId(int pid);
	Producers UpdateProducer(int pid,Producers detachedPojo);
	String deleteProducerById(int pid);
}
