package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Transaction;
import com.app.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private ITransactionService service;
	public TransactionController() {
		// TODO Auto-generated constructor stub
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping
	public ResponseEntity<?> listTransaction() {
		System.out.println("in list Producers.... " );
		List<Transaction> transactions= service.getAllTransactions();	
		if (transactions.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// non empty list
		return new ResponseEntity<>(transactions, HttpStatus.OK);
		}
	
	@PostMapping
	//@RequestBody => un marshalling
	public ResponseEntity<?> createNewTransaction(@RequestBody Transaction newTransaction) {
		System.out.println("in create Transaction " + newTransaction);
		try {
			Transaction transaction = service.addTransaction(newTransaction);
			return new ResponseEntity<>(transaction, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			e.printStackTrace();
			// resp pkt : set status code : 500 (server internal error)
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{tid}")
	public ResponseEntity<?> getTransactionDetailsbyId(@PathVariable int tid)
	{
		System.out.println("in get Transaction by id  "+tid);
		try
		{
		Optional<Transaction> t=service.getTransactionDetailsbyId(tid);
		return new ResponseEntity<>(t, HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
