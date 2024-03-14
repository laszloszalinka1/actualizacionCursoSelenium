package pages;

public class PaginaCursos extends BasePage {
    private String fundamentosTestingLink = "//*[text()='Fundamentos del Testing']";
    public PaginaCursos(){
        super(driver);
    }
    public void clickFundamentosTestingLink(){
        clickElement(fundamentosTestingLink);
    }

    
}
