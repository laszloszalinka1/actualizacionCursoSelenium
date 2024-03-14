package pages;

public class GooglePage extends BasePage{
    private String sectionLink = "//following::a[text()='%s' and @href]";
    private String elegirUnPlanButton = "//*[text()='Elegir Plan']";
    public GooglePage(){
        super(driver);
    }

    public void goToGoogle(){
        navigateTo("https://www.freerangetesters.com/");

    }
    public void clicSectionNavigationBar(String section){
        //reemplazar el marcador de posición %s
        String xpathSection = String.format(sectionLink, section);

        clickElement(xpathSection);

    }
    public void clickOnElegirPlanButton() {
        clickElement(elegirUnPlanButton);
    }

    
}
