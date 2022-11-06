package main;

import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

import data.ACoinData;
import data.ACoinUserData;
import data.User;
import db.SQL;
import ptdfj.PTDFJHandlerString;
import ptdfj.exceptions.runtime.NoDataAssignmentEexception;

public class CLIApp {

	public static SQL sqlH = new SQL();

	public CLIApp() {

		ACoinData aCoinData = CLIApp.sqlH.getACoinData();

		if (!aCoinData.getCurrent_app_version().equals(App.VERSION)) {

			System.out.println("Error this app version is not up to date!");

			System.exit(0);

		}

		if (!aCoinData.isCanMine()) {

			System.out.println("You can not mine aCoin right now!");

			System.exit(0);

		}

		String mineCode = "";
		User userData = null;
		ACoinUserData acoinData = null;

		while (mineCode == "") {

			mineCode = getText("Enter your aCoin mine code: ");

			try {

				String tString = new String(Base64.getDecoder().decode(mineCode));

				PTDFJHandlerString dataH = new PTDFJHandlerString(tString);

				long userID = Long.parseLong(dataH.get("user_id"));
				long acoinID = Long.parseLong(dataH.get("acoin_id"));

				userData = CLIApp.sqlH.getUserByID(userID);
				acoinData = CLIApp.sqlH.getAcoinUserDataByID(acoinID);


				if (userData == null) {

					System.exit(0);

				}

				if (acoinData == null) {

					System.exit(0);

				}

				break;

			} catch (NoDataAssignmentEexception e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		if (userData == null) {

			System.exit(0);

		}

		if (acoinData == null) {

			System.exit(0);

		}
		
		System.out.println(String.format("Hi, %s!", userData.getUsername()));
		System.out.println(acoinData.isLocked() ? "This user is locked!" : "This user is unlocked!");
		System.out.println(acoinData.isAdmin() ? "This user is a admin!" : "This user is not a admin!");
		System.out.println(String.format("You have %s aCoins!", String.valueOf(acoinData.getAcoins())));
		System.out.println(userData);
		System.out.println(acoinData);

	}

	public String getText(String ask) {

		Scanner scanner = new Scanner(System.in);

		System.out.print(ask);
		String res = scanner.next();

		scanner.close();

		return res;

	}

}
