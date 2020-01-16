package com.hemebiotech.analytics;

import java.util.*;
import java.util.Map.Entry;

import count.ICount;
import read.ISymptomReader;
import write.IWriteResult;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


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
        //2eme �tape: On lit le fichier symptoms.txt
        List<String> allSymptoms = reader.getSymptoms();

        //3eme �tape: On utilise la classe CountSymptom cette fois ci pour compter les symptoms.
        Map<String, Integer> symptomsCounter = counter.count(allSymptoms);

        //4eme �tape: On range dans l'ordre alphab�tique les symptoms.
        List<String> symptoms = sorter.sort(symptomsCounter.keySet());

        //5eme �tape: On �crit le fichier result.out
        for (String symptom: symptoms){
            writer.write(symptom, symptomsCounter.get(symptom));
        }
        writer.close();
    }
}