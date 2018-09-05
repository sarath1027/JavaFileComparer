package com.firstpackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompareTwoFiles {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String delimiter="\\|";
		String file1 = "E:\\Development\\JavaDev\\csv\\file1.csv";
		String file2 = "E:\\Development\\JavaDev\\csv\\file2.csv";
		List<String> file1Values;
		List<String> file2Values;
		try {
			file1Values = readFile(file1,delimiter);
			file2Values = readFile(file2,delimiter);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		List<String> differenceValues = compareList(file1Values, file2Values);
		for (String values : differenceValues) {
			System.out.println(values);
		}

	}

	private static List<String> compareList(List<String> listOne, List<String> listTwo) {

		List<String> diffreneObjsListfile2 = new ArrayList<String>();
		List<String> diffreneObjsListfile1 = new ArrayList<String>();

		for (String item : listTwo) {
			if (!listOne.contains(item)) {
				diffreneObjsListfile1.add(item);

			}
		}

    	System.out.println("Comparing file 2  with file 1");

		for (String values : diffreneObjsListfile1) {

			System.out.println(values);
		}

		return diffreneObjsListfile2;

	}

	private static List<String> readFile(String fileName,String delimiter) throws IOException {
		List<String> values = new ArrayList<String>();
		Scanner s = new Scanner(new File(fileName));
		List<String> strList = null;
		while (s.hasNextLine()) {
			String line = s.nextLine();
			String[] stringArr = line.split(delimiter);
			for (String stringValue : stringArr) {
				values.add(stringValue);
			}

		}
		return values;
	}
}
