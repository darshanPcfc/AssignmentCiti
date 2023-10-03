package Utility;

/**
 * Created by Darshan Patel 01/10/2023
 * Usage: list down all application constants and common methods here
 * How to call: call through class name and variable as all variable inside this class would be static
 */
public class UtilityConstants {
	//validation parameters for operation
	public static final char openAccount = 'O';
	public static final char closeAccount = 'C';
	public static final char transaction = 'T';
	public static final char accountBalance = 'B';
	public static final char allAccounts = 'L';
	public static final char exit = 'Q';
	
	//Console Messages for error scenarios
	public static final String msgAccountNotFound = "Invalid Account number";
	public static final String msgAccountAlreadyExist = "Account Already Exist";
	public static final String msgAccountCanNotBeClosed = "Account cannot be closed";
	public static final String msgTransferFromAccountInvalid = "Invalid Transfer From Account number";
	public static final String msgTransferToAccountInvalid = "Invalid Transfer To Account number";
	public static final String msgInsufficientBalance = "Insufficient Balance";
	public static final String msgInvalidCommand = "Invalid Command";
	public static final String msgNumberFormatIncorrect = "Incorrect number format for operation";
	public static final String msgSomethingWentWrong = "Something Went Wrong";
	public static final String msgWrongCommandFormat = "Command Format Is wrong";
	public static final String msgEnterCommand = "Enter Command: ";
	
	//splitting string based on space provided between operation accounts and amount
	public static String[] operationStrings(String inputOperation) {
		String[] splitStr = inputOperation.trim().split("\\s+");
		return splitStr;
	}
	
	//convert string to integer handle exception on respective calling method
	public static int stringToInt(String param) throws NumberFormatException {
        try {
                return Integer.valueOf(param);
        } catch(NumberFormatException e) {
               throw e;
        }
	}
	
	//common method to display console message
	public static void displayMessage(String msg) {
		System.out.println(msg);
	}
}
