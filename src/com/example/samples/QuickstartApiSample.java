/*
 * Name:				QuickstartApiSample
 * Created On:			2 Aug 2014
 * Author:				Vaibhaw Raj (vaibhaw.raj@comprotechnologies.com)
 * Description:			Quick Example from SOAP API Developer's Guide. It is a
 *						sample Java client application that uses the WSC SOAP
 *						client.
 * Change Log History :
 * |--------------------------------------------------------------------------|
 * | Version | Changes By   | Date       | Descripton                         |
 * |--------------------------------------------------------------------------|
 * | 0.1     | Vaibhaw      | 02-08-2015 | Initial version of Class           |
 * | 0.2     | Vaibhaw      | 03-08-2015 | Code Update                        |
 * |         |              |            |                                    |
 * |--------------------------------------------------------------------------|
 *
 */

package com.example.samples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectorConfig;
import com.sforce.ws.ConnectionException;
import com.sforce.soap.enterprise.GetUserInfoResult;

public class QuickstartApiSample {
	// Class Members
	private static BufferedReader reader = new BufferedReader ( new InputStreamReader(System.in));
	EnterpriseConnection connection;
	String authEndPoint = "";

	// Class Methods
	public static void main(String[] args) {
		// main Method
		if( args.length < 1 ) {
			System.out.println("Usage: com.example.samples.QuickstartApiSample <AuthEndPoint");
			System.exit(-1);
		}

		QuickstartApiSample sample = new QuickstartApiSample(args[0]);
		sample.run();
	}

	public void run() {
		// Run method Code goes here
		// Make a login call
		if ( login() ) {
			// Do some CRUD operation

			// Run Sample query

			// Logouts
			logout();
		}
		else {
			System.out.println("Login unsuccessful");
		}
	}

	public QuickstartApiSample(String authEndPoint) {
		this.authEndPoint = authEndPoint;
	}

	private String getUserInput(String prompt) {
		String result = "";
		try {
			System.out.print(prompt);
			result = reader.readLine();
		} catch ( IOException ioe ) {
			ioe.printStackTrace();
		}
		return result;
	}

	private boolean login() {
		boolean success = false;
		String username = getUserInput("Enter username: ");
		String password = getUserInput("Enter password: ");
		
		try {
			ConnectorConfig config = new ConnectorConfig();
			config.setUsername(username);
			config.setPassword(password + "tUrgmRrZjsKE0FqjTo4LuTmP");

			System.out.println("AuthEndPoint: " + authEndPoint);
			config.setAuthEndpoint(authEndPoint);

			connection = new EnterpriseConnection(config);
			printUserInfo(config);

			success = true;
		} catch ( ConnectionException ce ) {
			ce.printStackTrace();
		}
		return success;
	}

	private void logout() {
		try {
			connection.logout();
			System.out.println("Logged out");
		} catch (ConnectionException ce) {
			ce.printStackTrace();
		}
	}

	private void printUserInfo( ConnectorConfig config ) {
		try {
				GetUserInfoResult userInfo = connection.getUserInfo();

				System.out.println("\nLogging in .... \n");
				System.out.println("UserID: " + userInfo.getUserId());
				System.out.println("Full Name: " + userInfo.getUserFullName());
		} catch(ConnectionException ce) {
			ce.printStackTrace();
		}
	}
}
