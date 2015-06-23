package com.accenture.tmt.presentation.servlet;
import java.math.BigInteger;
import java.util.Scanner;


public class Apple {
	public static void main(String args[]) {
		try {
			Scanner scan = new Scanner(System.in);
			BigInteger myBigInteger = new BigInteger("0");
			BigInteger myBigInteger2 = new BigInteger("0");
			BigInteger myBigInteger3 = new BigInteger("0");
			BigInteger bigInt = new BigInteger("2");
			for (int q = 0; q < 10; q++) {
				myBigInteger = scan.nextBigInteger();
				myBigInteger2 = scan.nextBigInteger();
				
				myBigInteger3 = myBigInteger.subtract(myBigInteger2);
				myBigInteger3 = myBigInteger3.divide(bigInt);
				
				System.out.println(myBigInteger2.add(myBigInteger3));
				System.out.println(myBigInteger3);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}

