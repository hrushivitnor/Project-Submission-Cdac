package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Transport;

public interface ITransportService {
	List<Transport> getAllTransportCompanies();
	Transport addTransport(Transport transientTransport);
	Optional<Transport> getTransportDetailsbyId(int tcid);
	Transport UpdateTransport(int tcid,Transport detachedPojo);
	String deleteTransportById(int tcid);
}
