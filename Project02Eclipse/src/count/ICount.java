package count;

import java.util.List;
import java.util.Map;
/**
 * Count symptom occurrences
 * The important part is, the return value from the operation, is a Map with the symptoms(keys) are paired with occurrences (value)
 * Each time the symptom match with one of the symptoms List we increment +1 to the value
 * Otherwise the value will remain at 1
 */
public interface ICount {

	Map<String, Integer> count(List<String> symptoms);

}