


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PhoneList {

	public static void main(String[] args) throws FileNotFoundException{
	    Scanner sc = new Scanner(System.in);		
		List<String[]> tests = new LinkedList<>();		
		String[] test = {};
		int count = 0;
		int phoneNumber = 0;
		int records = 0;
		while (sc.hasNextLine()) {
			String val = sc.nextLine();
			if (count == 0) {				
				count++;
			} else {				
				if (records == 0) {
					records = Integer.parseInt(val);
					phoneNumber = 0;
					test = new String[Integer.parseInt(val)];
					tests.add(test);
				} else {
					tests.get(tests.size() - 1)[phoneNumber] = val;
					phoneNumber++;
					records--;
				}
			}
		}
		sc.close();
		PhoneList phoneList = new PhoneList();
		for (String[] arrPhones : tests) {
			System.out.println((phoneList.isUnicListNumbers(arrPhones) ? "YES" : "NO"));
		}
	}

	public boolean isUnicListNumbers(String[] listNumbers) {
		Arrays.sort(listNumbers);
		for (int i = 0; i < listNumbers.length - 1 ; i++) {
			boolean isNo = false;
			if (listNumbers[i].length() > listNumbers[i + 1].length()) {
				if (listNumbers[i].indexOf(listNumbers[i + 1]) == 0) {
					isNo = true;
				}
			} else {
				if (listNumbers[i + 1].indexOf(listNumbers[i]) == 0) {
					isNo = true;
				}
			}
			if (isNo) {
				return false;
			}
		}
		return true;
	}
}
