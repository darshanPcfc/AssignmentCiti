package BranchBankCitiTestMain;

import Utility.UtilityConstants;

/**
 * Created by Darshan Patel 01/10/2023 
 * Usage: Class to carry out operation to fetch balance of a account
 * How to call: Use class object to use this class
 */
public class BankFetchAccountBalance {

	public BankFetchAccountBalance() {}

	public void checkBalance(Integer accountNumber) {
		// check if account Exist
		if (DataStore.getInstance().getBankAccountDataSet().containsKey(accountNumber)) {
			// display balance of given account
			UtilityConstants.displayMessage(DataStore.getInstance().getBankAccountDataSet().get(accountNumber).toString());
		} else {
			UtilityConstants.displayMessage(UtilityConstants.msgAccountNotFound);
		}

	}
}
