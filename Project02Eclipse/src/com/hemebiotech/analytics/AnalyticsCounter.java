package com.hemebiotech.analytics;

import java.util.*;
import count.ICount;
import read.ISymptomReader;
import write.IWriteResult;




public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ICount counter;
	private final IWriteResult writer;
	
	public AnalyticsCounter(ISymptomReader reader, ICount counter,  IWriteResult writer) {
        this.reader = reader;
        this.counter = counter;
        this.writer = writer;
    }
	
	public void execute() throws Exception {
        //1eme �tape: On lit le fichier symptoms.txt
        List<String> allSymptoms = reader.getSymptoms();

        //2eme �tape: On utilise la classe CountSymptom cette fois ci pour compter les symptoms.
        Map<String, Integer> symptomsCounter = counter.count(allSymptoms);
        Set<String> symptoms = symptomsCounter.keySet();
        //3eme �tape: On �crit le fichier result.out
        for (String symptom: symptoms){
            writer.write(symptom, symptomsCounter.get(symptom));
        }
        writer.close();
    }
}