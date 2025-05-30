/* Copyright [yyyy] [name of copyright owner]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */


package bmicalc.bbd;

import bmicalc.BMICalcImpl;
import bmicalc.ObesityCategory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;

public class StepDefinitions {
	BMICalcImpl calc = new BMICalcImpl();
    double mass, height, bmi;
    ObesityCategory category;
    double waistCircumference;
    char gender;
    boolean abdominalObesity;   
    
    
    
    @Given("mass is {double} kg")
    public void mass_is_kg(Double m) {
    	mass = m;
    }
    @Given("height is {double} m")
    public void height_is_m(Double h) {
        height = h;
    }
    @When("BMI is calculated")
    public void bmi_is_calculated() {
    	bmi = calc.calculateBodyMassIndex(mass, height);
    }
    @Then("BMI should be {double}")
    public void bmi_should_be(Double expectedBMI) {
    	Assertions.assertEquals(expectedBMI, bmi, 0.1);
    }
    
    
    @Given("BMI is {double}")
    public void bmi_is(Double value) {
    	bmi = value;
 
    }
    @When("BMI category is determined")
    public void bmi_category_is_determined() {
        category = calc.getObesityCategory(bmi);
        
    }
    @Then("BMI category should be {string}")
    public void bmi_category_should_be(String expectedCategory) {
    	Assertions.assertEquals(expectedCategory, category);
    }
    
    
    
}
    
   
    
  
    
    
    
    
    
   


 