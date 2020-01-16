package count;

import java.util.*;

public class Count implements ICount {
	  
	    @Override
		public Map<String, Integer> count(List<String> symptoms){
	        Map<String, Integer>  symptomsCounter = new HashMap<>();

	        for (String symptom : symptoms){
	            if (symptomsCounter.containsKey(symptom)) {
	                symptomsCounter.put(symptom,symptomsCounter.get(symptom)+1);
	            } else {
	                symptomsCounter.put(symptom,1);
	            }
	        }
	        return symptomsCounter;
	    }

}
