package pages;

public class PaginaFundamentosTesting extends BasePage {
    private String inroduccionTestingLink = "//following::a[@href='/introduccion-al-testing-de-software'][2]";
    public PaginaFundamentosTesting(){
        super(driver);
    }
    public void clickIntroduccionTestingLink(){
        clickElement(inroduccionTestingLink);
    }

    
}
