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
import com.sforce.soap.enterprise.EnterpriseConnection;


public class QuickstartApiSample {
	// Class Members
	private static BufferedReader reader = new BufferedReader ( new InputStreamReader(System.in));
	EnterpriseConnection connection;
	String authEndPoint = "";

	// Class Methods
	public static void main(String[] args) {
		if( args.length < 1 ) {
			System.out.println("Usage: com.example.samples.QuickstartApiSample <AuthEndPoint");
			System.exit(-1);
		}

		QuickstartApiSample sample = new QuickstartApiSample(args[0]);
		sample.run();
	}
}
