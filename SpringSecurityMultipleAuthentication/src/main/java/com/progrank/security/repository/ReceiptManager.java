package com.progrank.security.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ReceiptManager {
	
	private Set<String>	receiptNoList;

	public ReceiptManager() {
		this.receiptNoList = new HashSet<String>();
	}
	
	public void add(String receipt) {
		receiptNoList.add(receipt);
	}
	
	public boolean contains(String receipt) {
		return receiptNoList.contains(receipt);
	}


}
