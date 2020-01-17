package write;

import java.io.IOException;
/**
 * We Write the output of the symptoms with the "count" of occurrences to a targetFile 
 * If this Target file is not found we return an Exception
 */
public interface IWriteResult {

	void write(String symptom, Integer count) throws IOException;

	void close() throws IOException;

}