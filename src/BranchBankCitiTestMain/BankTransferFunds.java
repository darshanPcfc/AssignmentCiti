package BranchBankCitiTestMain;

import java.math.BigDecimal;

import Utility.UtilityConstants;

/**
 * Created by Darshan Patel 01/10/2023 
 * Usage: Class to carry out operation to transfer funds between accounts
 * How to call: Use class object to use this class
 */
public class BankTransferFunds {

	public BankTransferFunds() {}
	
	public void transferFunds(Integer fromAccount, Integer toAccount, BigDecimal amount) {
		//check if from account present
		if (DataStore.getInstance().getBankAccountDataSet().containsKey(fromAccount)) {
			//check if to account present
			if (DataStore.getInstance().getBankAccountDataSet().containsKey(toAccount)) {
				// transfer if sufficient balance present
				if (DataStore.getInstance().getBankAccountDataSet().get(fromAccount).compareTo(amount) >= 0) {
					BigDecimal newFromAccountBalance = DataStore.getInstance().getBankAccountDataSet().get(fromAccount).subtract(amount);
					DataStore.getInstance().getBankAccountDataSet().put(fromAccount, newFromAccountBalance);
					BigDecimal newToAccountBalance = DataStore.getInstance().getBankAccountDataSet().get(toAccount).add(amount);
					DataStore.getInstance().getBankAccountDataSet().put(toAccount, newToAccountBalance);
				} else {
					// error message if insufficient balance 
					UtilityConstants.displayMessage(UtilityConstants.msgInsufficientBalance);
				}
			} else {
				// error message if wrong to account entered
				UtilityConstants.displayMessage(UtilityConstants.msgTransferToAccountInvalid);
			}
		} else {
			// error message if wrong from account entered
			UtilityConstants.displayMessage(UtilityConstants.msgTransferFromAccountInvalid);
		}
	}

}
