package com.hemebiotech.analytics;

import java.util.*;
import count.ICount;
import read.ISymptomReader;
import write.IWriteResult;

/**
 * Interfaces Implementation and initialization
 *
 */


public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ICount counter;
	private final IWriteResult writer;
	
	public AnalyticsCounter(ISymptomReader reader, ICount counter,  IWriteResult writer) {
        this.reader = reader;
        this.counter = counter;
        this.writer = writer;
    }
	/**
	 * An execute in 3 read , count , write that we will use in our Main class
	 *
	 */
	public void execute() throws Exception {
        //1 Step: Read the file symptoms.txt
        List<String> allSymptoms = reader.getSymptoms();

        //2 Step: Using Count Class to count symptoms occurrences in the symptom File.
        Map<String, Integer> symptomsCounter = counter.count(allSymptoms);
        Set<String> symptoms = symptomsCounter.keySet();
        //3 Step: Write occurrences in the  result.out File
        for (String symptom: symptoms){
            writer.write(symptom, symptomsCounter.get(symptom));
        }
        writer.close();
    }
}