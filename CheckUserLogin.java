import java.io.*;
import java.util.*;
import org.apache.log4j.*;
import com.shipcore.sdk.*;

public class CheckUserLogin implements com.shipcore.sdk.IShipCore{
	
	// The main body of the test logic goes here. If you have defined
	// any user inputs using the "getInputs()" method below, those
	// inputs will be passed in at runtime in the 'input' parameter, using
	// the input name as the map key. 
	
	public TestResult execute(HashMap<String, String> inputs){
		
		// initialize a TestResult object, which we will
		// return to the framework at the end of the method call.
		TestResult tResult = null;
		
		
		// get our "Test URL" parameter from the map. The
		// name you use must match the name you defined in the 
		// "getInputs()" method below exactly. 
		
		String urlString = inputs.get("Test URL");
		
		String portString = inputs.get("Port");
		
		String sslChoice = inputs.get("SSL Allowed?");
		
		String languageChoice = inputs.get("Which Language?");
		
		
		// now assert whether the url passed in 
		// equals what we expect. 
		if(urlString.equals("www.shipcore.com") && portString.equals("80") && sslChoice.equals("Yes, allow SSL") && languageChoice.equals("English")){
			
			tResult = new TestResult(TestResult.PASS, "All of the checks for this test passed.");
			
		}else{
			
			tResult = new TestResult(TestResult.FAIL, "At least one of the checks for this test failed");
		}
		
		
		
		// return the TestResult object to the framework. 
		return tResult;
	}
	
	
	
	// Provide a friendly description for this test, so others
	// can easily understand it's purpose:
	
	public String getDescription(){
		return "Makes sure we can login as an Administrator to the ShipCore Dashboard";
	}
	
	// If you test requires input from a user to run, 
	// define those inputs here. They will be passed to the
	// execute() method above at test time. If this test
	// does not require any inputs, just return null from this
	// method. 
	
	public ArrayList<TestInput> getInputs(){
		
		ArrayList<TestInput> inputs = new ArrayList<TestInput>();
		
		// we want the user to pass in a String we call "Test URL". So
		// create that input, give it a type and name, and add it to
		// our list. In this case, we don't provide a default value
		// for the input. 
		
		TestInput urlInput = new TestInput(TestInput.TEXT, "Test URL");
		inputs.add(urlInput);
		
		// We also want an input called "Port". In this case, we specify
		// a value of "80" as a default value using the alternate constructor.
		TestInput portInput = new TestInput(TestInput.TEXT, "Port", "80");
		inputs.add(portInput);
		
		// Here we will define another TestInput, this type a Boolean. Booleans
		// require you to also pass in a list of two "Options" that make
		// up the choice. The first option added will be the default option
		// provided to the user. A boolean MUST provide two(2) and only
		// two(2) options. If you want more options, use a SELECT input. 
		ArrayList<String> booleanOptions = new ArrayList<String>();
		booleanOptions.add("Yes, allow SSL");
		booleanOptions.add("No, do not allow SSL");
		
		TestInput allowSslBoolean = new TestInput(TestInput.BOOLEAN, "SSL Allowed?", booleanOptions);
		inputs.add(allowSslBoolean);
		
		
		// Similar to a boolean, a SELECT input requires a set
		// of options to a user. A SELECT allows you to provide longer list
		// of options. As with the BOOLEAN input, the first option added 
		// will be the default option provided to the user. 
		ArrayList<String> selectOptions = new ArrayList<String>();
		selectOptions.add("English");
		selectOptions.add("Spanish");
		selectOptions.add("Italian");
		selectOptions.add("Mandarin");
		
		TestInput whichLanguageSelect = new TestInput(TestInput.SELECT, "Which Language?", selectOptions);
		inputs.add(whichLanguageSelect);
		
		
		
		return inputs;
	}
	
	

}
