package appium;

import java.io.File;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.cucumber.listener.ExtentCucumberFormatter"},
features = { "Feature" },
glue = { "appium" })

public class RunCukeTest {

    @BeforeClass
    public static void setup() {
        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
        ExtentCucumberFormatter.initiateExtentCucumberFormatter();
        
        // Loads the extent config xml to customize on the report.
        ExtentCucumberFormatter.loadConfig(new File("/Users/gopikannan/Documents/Appium Session/extentreports-java-v2.41.1/extent-config.xml"));
    	
    	    }
}
