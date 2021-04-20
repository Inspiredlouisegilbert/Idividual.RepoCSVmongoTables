package readFromCSV;

import java.io.IOException;

public class BankProjectMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		BankProjectKeywords bpKeywords = new BankProjectKeywords();
		
		// call runTest
		bpKeywords.runTestStart();
		bpKeywords.runTestReadFromFile();
	}
}