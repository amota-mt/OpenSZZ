package  com.SZZ.jiraAnalyser.entities;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import  com.SZZ.jiraAnalyser.git.*;

public class TransactionManager {
	
	private List<Transaction> transactions;
	
	//private List<Transaction> totalTransactions;
	
	private Storage storage;

	/**
	 * Gets transaction containing at least one number or keyword that suggests it could be a bug
	 * @param url
	 * @return
	 */
	public List<Transaction> getBugFixingCommits(URL url, String projectName) {
		if (this.transactions != null) return this.transactions;
		
		this.transactions = new ArrayList<Transaction>(); 
	
		// TODO: Parse stuff from url
		try {
			storage = new Storage(projectName);
			transactions = this.storage.checkoutCvs(url,projectName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Transaction> t = new LinkedList<Transaction>();
	    for (Transaction tran : this.transactions){
	    	if (!tran.hasBugId())
	    		t.add(tran);
	    }
	    this.transactions.removeAll(t);
			
		return transactions;
	}

	public Git getGit(){
		return this.storage.getGit();
	}
}
