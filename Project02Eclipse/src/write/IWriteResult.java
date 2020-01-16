package write;

import java.io.IOException;

public interface IWriteResult {

	void write(String symptom, Integer count) throws IOException;

	void close() throws IOException;

}