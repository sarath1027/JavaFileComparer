package com.firstpackage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class CsvComparer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String delimiter = "\\|";
		String file1 = "E:\\Development\\JavaDev\\csv\\file1.csv";
		String file2 = "E:\\Development\\JavaDev\\csv\\file2.csv";
		HashMap<Integer, List<String>> file1Values = null;
		HashMap<Integer, List<String>> file2Values = null;
		try {
			file1Values = readFile(file1, delimiter);
			file2Values = readFile(file2, delimiter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Map.Entry<Integer, List<String>> pair : file2Values.entrySet()) {

			List<String> lstValues = file1Values.get(pair.getKey());

			if (lstValues != null) {
				//System.out.println("key:" + pair.getKey() + "Value:" + pair.getValue());

				if (compareList(lstValues, pair.getValue())) {
					System.out.println("line has difference:" + pair.getKey() + " Value:" + pair.getValue());
				}
			}	
			else
			{
				System.out.println("line has new rows:" + pair.getKey()+ " Value:" + pair.getValue());
			}
		}
	}

	private static boolean compareList(List<String> listOne, List<String> listTwo) {

		boolean isDiffernce = false;

		for (String item : listTwo) {
			if (!listOne.contains(item)) {
				isDiffernce = true;
			}
		}
		return isDiffernce;
	}

	/*
	 * private static List<String[]> readFile(String fileName,String delimiter)
	 * throws IOException { List<String[]> values = new ArrayList<String[]>();
	 * Scanner s = new Scanner(new File(fileName)); while (s.hasNextLine()) {
	 * String line = s.nextLine(); values.add(line.split(delimiter)); } return
	 * values; }
	 */

	private static HashMap<Integer, List<String>> readFile(String fileName, String delimiter) throws IOException {
		HashMap<Integer, List<String>> values = new HashMap<Integer, List<String>>();
		Scanner lines = new Scanner(new File(fileName));
		int lineNo = 0;

		while (lines.hasNextLine()) {
			String line = lines.nextLine();
			String[] items = line.split(delimiter);
			if (items != null) {
				values.put(lineNo, Arrays.asList(items));
			}
			lineNo = lineNo + 1;
		}
		lines.close();
		return values;
	}

}
