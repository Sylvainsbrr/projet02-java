package com.hemebiotech.analytics;

import java.util.*;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class AnalyticsCounter {


	static Map<String, Integer> frequency = new HashMap<>();

	static BufferedWriter writer;

	
	public static void main(String args[]) throws Exception {

		// File Reader
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		//File writer
		writer = new BufferedWriter(new FileWriter("result.out", true));

		String line;

		String symptoms;

		// read lines until reaching the end of the file
		while ((line = reader.readLine()) != null) {

			symptoms = line;

			if (line.length() != 0) {

				if (frequency.containsKey(symptoms)) {
					frequency.put(symptoms, frequency.get(symptoms) + 1);// Increment 1 if a key match a symptom
				} else {
					frequency.put(symptoms, 1);// If the key match only one time set value to 1
				}

			}

		}
		//Writting the output on the result.out file
		for (Entry<String, Integer> count : frequency.entrySet()) {
			System.out.println(count.getKey() + "=" + count.getValue());//preview result.out file
			writer.write(count.getKey() + "=" + count.getValue());
			writer.newLine();
			writer.flush();
		}
		
		// Closing Resources
		reader.close();

	}


	
}
