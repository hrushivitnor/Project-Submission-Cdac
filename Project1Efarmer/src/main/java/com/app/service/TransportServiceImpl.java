package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITransportDao;
import com.app.pojos.Producers;
import com.app.pojos.Transport;
@Service
@Transactional
public class TransportServiceImpl implements ITransportService {
	@Autowired
	private ITransportDao dao;
	public TransportServiceImpl() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@Override
	public List<Transport> getAllTransportCompanies() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Transport addTransport(Transport transientTransport) {
		// TODO Auto-generated method stub
		return dao.save(transientTransport);
	}

	@Override
	public Optional<Transport> getTransportDetailsbyId(int tcid) {
		// TODO Auto-generated method stub
		return dao.findById(tcid);
	}

	@Override
	public Transport UpdateTransport(int tcid, Transport detachedPojo) {
		Optional<Transport> existingTransport=dao.findById(tcid);
		if(existingTransport.isPresent())
		{
			Transport t=existingTransport.get();
			t.setcName(detachedPojo.getcName());
			t.setAddress(detachedPojo.getAddress());
			t.setCity(detachedPojo.getCity());
			t.setContactNo(detachedPojo.getContactNo());
			t.setPricePerKm(detachedPojo.getPricePerKm());
			
		return t;
		}
		return null;
	}

	@Override
	public String deleteTransportById(int tcid) {
		dao.deleteById(tcid);
		return "Transport Company with id "+tcid+" deleted succesfully";
	}

}
