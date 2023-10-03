package BranchBankCitiTestMain;

import java.math.BigDecimal;

import Utility.UtilityConstants;

/**
 * Created by Darshan Patel 01/10/2023 
 * Usage: Class to carry out operation to close a particular account
 * How to call: Use class object to use this class
 */
public class BankCloseAccount {

	public BankCloseAccount() {}

	public void closeAccount(Integer accountNumber) {
		// check if account Exist
		if (DataStore.getInstance().getBankAccountDataSet().containsKey(accountNumber)) {
			// check if account has balance or account number is 999
			if (accountNumber == 999 || DataStore.getInstance().getBankAccountDataSet().get(accountNumber)
					.compareTo(BigDecimal.ZERO) > 0) {
				UtilityConstants.displayMessage(UtilityConstants.msgAccountCanNotBeClosed);
			} else {
				// remove account from dataset
				DataStore.getInstance().getBankAccountDataSet().remove(accountNumber);
			}
		} else {
			// account not found
			UtilityConstants.displayMessage(UtilityConstants.msgAccountNotFound);
		}
	}
}
