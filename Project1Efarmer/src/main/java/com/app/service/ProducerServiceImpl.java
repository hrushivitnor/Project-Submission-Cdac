package com.app.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProducerDao;
import com.app.pojos.Buyers;
import com.app.pojos.Producers;
@Service
@Transactional
public class ProducerServiceImpl implements IProducerService {
	@Autowired
	private IProducerDao dao;
	public ProducerServiceImpl() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@Override
	public List<Producers> getAllProducers() {
		// TODO Auto-generated method stub
		return dao.findAll();

	}

	@Override
	public Producers addProducer(Producers transientProducer) {
		return dao.save(transientProducer);
		
	}

	@Override
	public Optional<Producers> getProducerDetailsbyId(int pid) {
		
		return dao.findById(pid);
	}

	@Override
	public Producers UpdateProducer(int pid, Producers detachedPojo) {
		Optional<Producers> existingProducer=dao.findById(pid);
		if(existingProducer.isPresent())
		{
			Producers p=existingProducer.get();
			p.setPname(detachedPojo.getPname());
			p.setEmailId(detachedPojo.getEmailId());
			p.setAddress(detachedPojo.getAddress());
			p.setDistrict(detachedPojo.getDistrict());
			p.setCity(detachedPojo.getCity());
			p.setPincode(detachedPojo.getPincode());
			p.setState(detachedPojo.getState());
			p.setContactNo(detachedPojo.getContactNo());
			p.setAccountNo(detachedPojo.getAccountNo());
			p.setAccountDetials(detachedPojo.getAccountDetials());
		return p;
		}
		return null;
	}
	@Override
	public String deleteProducerById(int pid) {
		dao.deleteById(pid);
		return "Producer  with id"+pid+" is deleted";
	
	}

}
