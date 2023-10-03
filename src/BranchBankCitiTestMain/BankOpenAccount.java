package BranchBankCitiTestMain;

import java.math.BigDecimal;

import Utility.UtilityConstants;

/**
 * Created by Darshan Patel 01/10/2023 
 * Usage: Class to carry out operation to open a account with zero balance
 * How to call: Use class object to use this class
 */
public class BankOpenAccount {

	public BankOpenAccount() {}

	public void openBankAccount(Integer accountNumber) {
		// check if account Exist
		if (DataStore.getInstance().getBankAccountDataSet().containsKey(accountNumber)) {
			UtilityConstants.displayMessage(UtilityConstants.msgAccountAlreadyExist);
		} else {
			DataStore.getInstance().getBankAccountDataSet().put(accountNumber, new BigDecimal(0));
		}
	}

}
