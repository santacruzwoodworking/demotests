import java.util.*;
import com.shipcore.sdk.*;


public class Simple implements com.shipcore.sdk.IShipCore{
	
	
	
	
	public TestResult execute(HashMap<String, String> inputs){
		
		TestResult tResult = null;
		
		
		
		
		if(true){
			tResult = new TestResult(TestResult.PASS, "The test was successful.");
		}else{
			
			tResult = new TestResult(TestResult.FAIL, "The test was not successful.");
		}
		
		// return the TestResult object to the framework. 
		return tResult;
	}
	
	
	
	
	
	
	

	public String getDescription(){
		return "The Simplest possible test definition, for demo purposes.";
	}
	
	
	public ArrayList<TestInput> getInputs(){
		return null;
	}
	
	

}
