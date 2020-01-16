package com.hemebiotech.analytics;

import count.Count;
import count.ICount;
import read.ISymptomReader;
import read.ReadSymptomDataFromFile;
import write.IWriteResult;
import write.WriteResult;

public class Main {

	public static void main(String[] args) throws Exception {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ICount counter = new Count();
        IWriteResult writer = new WriteResult("result.out");

        new AnalyticsCounter(
                reader,counter,writer
        ).execute();
    }
}
