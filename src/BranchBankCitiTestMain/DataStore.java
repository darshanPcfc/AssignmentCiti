package BranchBankCitiTestMain;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by Darshan Patel 01/10/2023 
 * Usage: Data store class to store data in a hashmap for using throughout the application
 * How to call: Use getInstance method to get object of class
 * Additional Info: Had made this class singleton 
 * as it would be called from many places and to avoid multiple object creation
 */
public class DataStore {
	private HashMap<Integer, BigDecimal> bankAccountDataSet = new HashMap<>();

	private static DataStore dataStore;
	
	public HashMap<Integer, BigDecimal> getBankAccountDataSet() {
		return bankAccountDataSet;
	}

	private DataStore(Integer accountNumber,BigDecimal balance) {
		//bankAccountData = new HashMap<>();
		bankAccountDataSet.put(accountNumber, balance);
	}
	
	public static DataStore getInstance(){
        if(dataStore == null){
        	dataStore = new DataStore(999, new BigDecimal(1000));
        }
        return dataStore;
 }

}
