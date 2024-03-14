package steps;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.GooglePage;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaRegistro;

public class GoogleSteps {
    GooglePage google = new GooglePage();
    PaginaCursos cursos = new PaginaCursos();
    PaginaFundamentosTesting fundamentosTesting = new PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();
    @Given("I navigate to www.freerangetesters.com")
    public void navigateToGoolge(){
        google.goToGoogle();

    }
    @When("I go to {word} using the navigation bar")
    public void navigateToSections(String section){
        google.clicSectionNavigationBar(section);
    }
    @When("I select Elegir Plan")
    public void elegirPlan(){
        google.clickOnElegirPlanButton();
    }
    @And("select Introduccion al Testing")
    public void navigateToIntrodution(){
        cursos.clickFundamentosTestingLink();
        fundamentosTesting.clickIntroduccionTestingLink();
    }
     @Then("I can validate the options in the checkout page")
    public void validateCheckoutPlans() {
        List<String> lista = registro.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 11 productos",
                "Academia: $176 / año • 11 productos", "Free: Gratis • 1 producto");
 
        Assert.assertEquals(listaEsperada, lista);
    }
 

}
