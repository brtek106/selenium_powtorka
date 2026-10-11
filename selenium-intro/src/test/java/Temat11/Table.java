package Temat11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table {

    //Deklaracja obiektu tabelki
    private WebElement table;

    //Deklaracja listy wierszy
    private List<WebElement> rows;

    //Deklaracja listy kolumn
    private List<WebElement> columns;

    public Table(WebDriver driver, By tableLocator) {

        //Tworzymy WebElement reprezentujący tabelkę
        table = driver.findElement(tableLocator);

        //Dodajemy do listy kolumn, wszystkie dostępne kolumny
        columns = table.findElements(By.xpath("thead//span"));

        //Dodajemy do listy wierszy, wszystkie wiersze
        rows = table.findElements(By.xpath("tbody/tr"));
    }

    //Metoda zwraca ilość wierszy
    public int getNumberOfRows() {
        int size = rows.size();
        return size;
    }

    //Metoda zwraca ilość kolumn
    public int getNumberOfColumns() {
        int size = columns.size();
        return size;
    }

    //Metoda zwraca WebElement Last Name dla danego wiersza
    public WebElement getLastNameForRow(int rowIndex) {
        WebElement lastNameRow = rows.get(rowIndex).findElement(By.xpath("td[1]"));
        return lastNameRow;
    }

    //Metoda zwraca WebElement Web Site dla danego wiersza
    public WebElement getWebSiteForRow(int rowIndex) {
        WebElement webSiteRow = rows.get(rowIndex).findElement(By.xpath("td[5]"));
        return webSiteRow;
    }

}