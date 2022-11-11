package boundary;

import control.AccountFileManager;
import control.AccountManager;
import control.InputManager;
import entity.Account;

public class MainApplication {
	
	public static Account currentAcc = null;
	public static AccountManager accMgr = new AccountFileManager();
	
	
	public static void main(String[] args) {
		int choice;
		
		//get input from user
		do {
			System.out.println("|----------------------------|");
			System.out.println("|---------*MOBLIMA*----------|");
			System.out.println("|----------------------------|");
			System.out.println("1. Login");
			System.out.println("2. Exit");
			choice = InputManager.getInt(1, 2);
			
			switch(choice) {
			case 1:
				login();
				break;
			case 2:
				System.out.println("Thank you for using MOBLIMA! Have a nice day!");
				System.out.println("Exiting MOBLIMA...");
				break;
			default:
			}
			
		}while(choice !=2);
	}
	
	
	public static void login() {
		
		//verify the user and retrieve the user Account
		int choice=0;
		do {
			System.out.println("Please enter your username: ");
			String username = InputManager.getString();
			
			System.out.println("Please enter your password: ");
			String password = InputManager.getString();
			
			currentAcc = accMgr.verifyLogin(username, password);
			if(currentAcc==null) {
				System.out.println("Choose an option:");
				System.out.println("1. Try again");
				System.out.println("2. Exit");
				choice = InputManager.getInt(1, 2);
			}
		
		}while(currentAcc==null && choice == 1 );
	
	
	
	}

}
