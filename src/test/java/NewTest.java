import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NewTest extends BasicTest {
    String searchWithAttribute = "//div[@class='page_wrapper']";
    String getSearchWithText = "//div[text()='Sauce Labs Backpack']";
    String attributeContains = "//div[contains(@class,'login_password')]";
    String textText = "//h4[contains(text(),'usernames are:')]";
    String ancestor = " //span[text()='Name (A to Z)']/ancestor:: div[@class='right_component']";
    String descendant = "//div[@class='right_component']/descendant::span[text()='Name (A to Z)']";
    String following = "//div[@class='header_secondary_container']//following-sibling::div";
    String parent = "//div[@id='menu_button_container']//parent::div";
    String preceding = "//div[@class='header_secondary_container']//preceding::div";
    String and = "//a[@id='inventory_sidebar_link' and @style='display: block;']";

    String classCss = ".primary_header";
    String classClassCss = ".login-box .form_group";
    String idCss = "#root";
    String tagNameCss = "input[name='first_name']";
    String tagNameClassCss = "div.form_column";
    String attributeValueCss1 = "input[name='user-name']";
    String attributeValueCss2 = "";
    String attributeValueCss3 = "[lang|=en]";
    String attributeValueCss4 = "input[id^='user-']";
    String attributeValueCss5 = "input[id$='name']";
    String attributeValueCss6 = "div[id*='login']";

    @Test
    public void xPathLocator() {
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.xpath(searchWithAttribute));
        driver.findElement(By.xpath(getSearchWithText));
        driver.findElement(By.xpath(attributeContains));
        driver.findElement(By.xpath(textText));

        /*
       ancestor – предок, опять же отличающийся от parent тем, что может быть любой удаленности,
       то есть прадедушкой. Если возвращаться к предыдущему примеру, то найти элемент папки по тексту можно так
        //span[text()=’Folder name’]/ancestor:: div[@class=’listitem Folder’]
        Важно понимать, что можно, но крайне нежелательно использовать в одном локаторе несколько отношений, например:
       //div[@class=’One]/child::div[@class=’Two’]/descendant::input[@class=’Three].
          Такой локатор работать будет, но он уже сложно читается и скорее всего есть возможность подобрать другой,
            не нужно использовать такое без необходимости, помним правило номер 2.
             Совсем недопустимо использовать в одном локаторе обратные отношения то есть сначала искать потомка,
             потом его предка или наоборот.
        */
        driver.findElement(By.xpath(ancestor));

        /*descendant – потомок, но отличие от child это может быть потомок любой вложенности,
         так сказать пра-пра-внук в том числе, а не только сын,
         потому важно не путать с непосредственным наследником*/
        driver.findElement(By.xpath(descendant));

        driver.findElement(By.xpath(following));
        driver.findElement(By.xpath(parent));
        driver.findElement(By.xpath(preceding));
        driver.findElement(By.xpath(and));

        /*
        Шпаргалка
       Оси это основа запросов XPath и их обязательная часть.

ancestor:: — возвращает множество предков.
ancestor-or-self:: — возвращает множество предков и текущий элемент.
attribute:: — возвращает множество атрибутов текущего элемента.
child:: — возвращает множество потомков на один уровень ниже.
descendant:: — возвращает полное множество потомков.
descendant-or-self:: — возвращает полное множество потомков и текущий элемент.
following:: — возвращает необработанное множество, ниже текущего элемента.
following-sibling:: — возвращает множество элементов на том же уровне, следующих за текущим.
namespace:: — возвращает множество имеющее пространство имён (то есть присутствует атрибут xmlns).
parent:: — возвращает предка на один уровень назад.
preceding:: — возвращает множество обработанных элементов исключая множество предков.
preceding-sibling:: — возвращает множество элементов на том же уровне, предшествующих текущему.
self:: — возвращает текущий элемент.
Для наиболее часто используемых осей существуют сокращения:

attribute:: — можно заменить на «@»
child:: — часто просто опускают
descendant:: — можно заменить на «.//»
parent:: — можно заменить на «..»
self:: — можно заменить на «.»
        */
    }

    @Test
    void cssSelector() {
        driver.get("https://www.saucedemo.com/inventory.html");

        driver.findElement(By.cssSelector(classCss));
        driver.findElement(By.cssSelector(classClassCss));
        driver.findElement(By.cssSelector(idCss));

        driver.findElement(By.cssSelector(tagNameCss));
        driver.findElement(By.cssSelector(tagNameClassCss));

        driver.findElement(By.cssSelector(attributeValueCss1));
        driver.findElement(By.cssSelector(attributeValueCss2));
        driver.findElement(By.cssSelector(attributeValueCss3));
        driver.findElement(By.cssSelector(attributeValueCss4));
        driver.findElement(By.cssSelector(attributeValueCss5));
        driver.findElement(By.cssSelector(attributeValueCss6));

    }
}
