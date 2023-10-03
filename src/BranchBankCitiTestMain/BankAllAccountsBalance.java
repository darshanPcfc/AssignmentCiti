package BranchBankCitiTestMain;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Darshan Patel 01/10/2023 
 * Usage: Class to carry out operation for to display all accounts in ascending order by account number
 * How to call: Use class object to use this class
 */
public class BankAllAccountsBalance {

	public BankAllAccountsBalance() {}

	public void getAllAccounts() {
		// display whole data set in ascending order by account number
		DataStore.getInstance().getBankAccountDataSet().entrySet().stream()
				.sorted(Map.Entry.<Integer, BigDecimal>comparingByKey()).forEach(System.out::println);
	}

}
