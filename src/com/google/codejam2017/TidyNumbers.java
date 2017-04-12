package com.google.codejam2017;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class TidyNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int t = in.nextInt();
		try {
			PrintWriter writer = new PrintWriter("TidyNumbersOutput.txt", "UTF-8");
			TidyNumbers tidyNumber = new TidyNumbers();
			for (int i = 0; i < t; i++) {
				BigInteger k = in.nextBigInteger();
				BigInteger result = tidyNumber.lastTidyNumber(k);
				writer.println("Case #" + (i + 1) + ": " + result);
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Unable to write to file");
		}
		in.close();
	}

	BigInteger lastTidyNumber(BigInteger k) {
		boolean foundTidyNumber = false;

		BigInteger lastTidyNumber = k;
		while (!foundTidyNumber) {
			int maxNumber = 0;
			boolean untidyNumber = false;
			for (char ch : lastTidyNumber.toString().toCharArray()) {
				if (Character.getNumericValue(ch) >= maxNumber) {
					maxNumber = Character.getNumericValue(ch);
					continue;
				}
				untidyNumber = true;
				break;
			}
			if (untidyNumber) {
				lastTidyNumber = lastTidyNumber.subtract(BigInteger.ONE);
			} else {
				foundTidyNumber = true;
			}
		}
		return lastTidyNumber;
	}

}
