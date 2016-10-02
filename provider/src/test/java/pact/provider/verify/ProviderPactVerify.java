package pact.provider.verify;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import pact.provider.Application;
import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;


@RunWith(PactRunner.class) // Say JUnit to run tests with custom Runner
@Provider("Product_Catalogue_Provider") // Set up name of tested provider
@PactFolder("pacts") 
public class ProviderPactVerify {
    // NOTE: this is just an example of embedded service that listens to requests, you should start here real service
    /*@ClassRule //Rule will be applied once: before/after whole contract test suite
    public static final ClientDriverRule embeddedService = new ClientDriverRule(8332);*/

    @BeforeClass //Method will be run once: before whole contract test suite
    public static void setUpService() {
        //Run DB, create schema
        //Run service
        //...
    	
    
		Application.main(new String[]{});
    }

    @Before //Method will be run before each test of interaction
    public void before() {
        // Rest data
        // Mock dependent service responses
        // ...
       /* embeddedService.addExpectation(
                onRequestTo("/data"), giveEmptyResponse()
        );*/
    }

    @State("default") // Method will be run before testing interactions that require "default" or "no-data" state
    public void toDefaultState() {
        // Prepare service before interaction that require "default" state
        // ...
        System.out.println("Now service in default state");
    }

    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new HttpTarget(8080); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)
}