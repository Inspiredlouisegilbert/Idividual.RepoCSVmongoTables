package BankProjectGenerateData;
import java.io.IOException;

public class BankProjectGenerateDataMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		//CALL METHODS FROM KEYWORDS
		
		BankProjectGenerateDataKeywords bpGenerateInput = new BankProjectGenerateDataKeywords();
		bpGenerateInput.testCase1();
		//bpGenerateInput.testCase1();
		//bpGenerateInput.testCase2();
		bpGenerateInput.cleanup();
	}

}
