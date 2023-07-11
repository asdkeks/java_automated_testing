package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation(){
        click(By.linkText("add new"));
    }
    public void fillInContactForm(ContactData contactData, boolean creation) {
            if (creation){
                type(By.name("firstname"), contactData.getFirst_name());
                type(By.name("middlename"), contactData.getMiddle_name());
                type(By.name("lastname"), contactData.getLast_name());
                type(By.name("nickname"), contactData.getNickname());
                type(By.name("title"), contactData.getTitle());
                type(By.name("company"), contactData.getCompany());
                type(By.name("address"), contactData.getAddress());
                type(By.name("home"), contactData.getHome_telephone());
                type(By.name("mobile"), contactData.getMobile_telephone());
                type(By.name("work"), contactData.getWork_telephone());
                type(By.name("fax"), contactData.getFax_telephone());
                type(By.name("email"), contactData.getEmail());
                type(By.name("email2"), contactData.getEmail2());
                type(By.name("email3"), contactData.getEmail3());
                type(By.name("homepage"), contactData.getHomepage());
                select(By.name("bday"), contactData.getDayOfBirthday());
                select(By.name("bmonth"), contactData.getMonthOfBirthday());
                type(By.name("byear"), contactData.getYearOfBirthday());
                select(By.name("new_group"), contactData.getGroup());
            } else {
                type(By.name("firstname"), contactData.getFirst_name());
                type(By.name("lastname"), contactData.getLast_name());
                Assert.assertFalse(isElementPresent(By.name("new_group")));
            }
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void deleteSelectedContacts() {
        click(By.cssSelector("[value=Delete]"));
    }


    private void selectContactById(int id) {
        driver.findElement(By.id(String.valueOf(id))).click();
    }

    public void confirmDeletion(){
        confirmAlert();
    }

    public void initContactModificationById(int id) {
        driver.findElement(By.cssSelector("[href=\"edit.php?id=" + id + "\"]" )).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void create(ContactData contact, Boolean isCreation) {
        initContactCreation();
        fillInContactForm(contact, isCreation);
        submitContactCreation();
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillInContactForm(contact, false);
        submitContactModification();
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        confirmDeletion();
    }



    public boolean isThereNoContact() {
        return !isElementPresent(By.name("selected[]"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element: elements) {
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirst_name(firstName).withLast_name(lastName);
            contacts.add(contact);
        }
        return contacts;
    }
}
