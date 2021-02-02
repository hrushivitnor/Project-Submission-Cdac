package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Transaction;

public interface ITransactionService {
	List<Transaction> getAllTransactions();
	Transaction addTransaction(Transaction transientTransaction);
	Optional<Transaction> getTransactionDetailsbyId(int tid);
	
}
