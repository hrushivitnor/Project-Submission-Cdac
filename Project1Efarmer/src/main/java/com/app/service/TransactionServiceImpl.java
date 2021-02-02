package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITransactionDao;
import com.app.pojos.Transaction;
@Service
@Transactional
public class TransactionServiceImpl implements ITransactionService {
	@Autowired
	private ITransactionDao dao;
	public TransactionServiceImpl() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@Override
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Transaction addTransaction(Transaction transientTransaction) {
		// TODO Auto-generated method stub
		return dao.save(transientTransaction);
	}

	@Override
	public Optional<Transaction> getTransactionDetailsbyId(int tid) {
		// TODO Auto-generated method stub
		return dao.findById(tid);
	}

}
