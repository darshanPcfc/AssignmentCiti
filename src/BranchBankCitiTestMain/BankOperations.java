package BranchBankCitiTestMain;

import java.math.BigDecimal;
import java.util.Scanner;

import Utility.UtilityConstants;

/**
 * Created by Darshan Patel 01/10/2023 
 * Usage: Operation class to add all the banking operation 
 * How to call: This would be start point of program
 */
public class BankOperations {

	public BankOperations() {}
	
	protected void operation() {
		//defining operation char to distinguish between operation
		char operationType = ' ';
		while (operationType != 'Q') {
			UtilityConstants.displayMessage(UtilityConstants.msgEnterCommand);
			Scanner sc = new Scanner(System.in);
			String inputOperation = sc.nextLine();
			//fetch first character for identifying the operation
			operationType = inputOperation.stripLeading().charAt(0);
			//splitting string from input on basis of space in string for account and amount 
			//could throw ArrayIndexOutOfBoundsException when trying to access account and amount if not entered correctly
			String[] splitStr = UtilityConstants.operationStrings(inputOperation);
			try {
				if (operationType == UtilityConstants.openAccount) {
					//open account
					BankOpenAccount bankOpenAccount = new BankOpenAccount();
					bankOpenAccount.openBankAccount(UtilityConstants.stringToInt(splitStr[1]));
				} else if (operationType == UtilityConstants.accountBalance) {
					//account balance
					BankFetchAccountBalance bankFetchAccountBalance = new BankFetchAccountBalance();
					bankFetchAccountBalance.checkBalance(UtilityConstants.stringToInt(splitStr[1]));
				} else if (operationType == UtilityConstants.closeAccount) {
					//close account
					BankCloseAccount bankCloseAccount = new BankCloseAccount();
					bankCloseAccount.closeAccount(UtilityConstants.stringToInt(splitStr[1]));
				} else if (operationType == UtilityConstants.allAccounts) {
					//display all accounts
					BankAllAccountsBalance  bankAllAccountsBalance = new BankAllAccountsBalance();
					bankAllAccountsBalance.getAllAccounts();
				} else if (operationType == UtilityConstants.transaction) {
					//transfer between accounts
					//BigDecimal amount = BigDecimal.valueOf(UtilityConstants.stringToInt(splitStr[3]));
					BigDecimal amount = new BigDecimal(splitStr[3]);
					BankTransferFunds bankTransferFunds = new BankTransferFunds();
					bankTransferFunds.transferFunds(UtilityConstants.stringToInt(splitStr[1]), 
							UtilityConstants.stringToInt(splitStr[2]),
							amount);
				} else if (operationType == UtilityConstants.exit) {
					// close scanner and exit
					sc.close();
					break;
				} else {
					//Invalid operation entered
					UtilityConstants.displayMessage(UtilityConstants.msgInvalidCommand);
				}
			} catch (NumberFormatException nE) {
				//NumberFormatException if account number is alphanumeric
				UtilityConstants.displayMessage(UtilityConstants.msgNumberFormatIncorrect);
				nE.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException aE) {
				//ArrayIndexOutOfBoundsException if accessing string array for accounts and it wasn't entered
				UtilityConstants.displayMessage(UtilityConstants.msgWrongCommandFormat);
				aE.printStackTrace();
			} catch (Exception e) {
				//Exception general and displaying common message
				UtilityConstants.displayMessage(UtilityConstants.msgSomethingWentWrong);
				e.printStackTrace();
			}
		}
	}

}
