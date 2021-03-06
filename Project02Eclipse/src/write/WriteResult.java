package write;

import java.io.FileWriter;
import java.io.IOException;
/**
 * Simple brute force implementation
 *
 */
public class WriteResult implements IWriteResult{
	
	 private final FileWriter writer;

	    public WriteResult(String targetFile) throws IOException {
	        this.writer = new FileWriter(targetFile);
	    }

	    @Override
		public void write(String symptom, Integer count) throws IOException {
	        writer.write(symptom+"="+count+"\n");
	    }

	    @Override
		public void close() throws IOException {
	        writer.close();
	    }

}
