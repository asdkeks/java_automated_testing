package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
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
                type(By.name("email3"), contactData.getEmail2());
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

    //    public void fillInEditContactForm(ContactData contactData) {
//        type(By.name("firstname"), contactData.getFirst_name());
//        type(By.name("middlename"), contactData.getMiddle_name());
//        type(By.name("lastname"), contactData.getLast_name());
//        type(By.name("nickname"), contactData.getNickname());
//        type(By.name("title"), contactData.getTitle());
//        type(By.name("company"), contactData.getCompany());
//        type(By.name("address"), contactData.getAddress());
//        type(By.name("home"), contactData.getHome_telephone());
//        type(By.name("mobile"), contactData.getMobile_telephone());
//        type(By.name("work"), contactData.getWork_telephone());
//        type(By.name("fax"), contactData.getFax_telephone());
//        type(By.name("email"), contactData.getEmail());
//        type(By.name("email2"), contactData.getEmail2());
//        type(By.name("email3"), contactData.getEmail3());
//        type(By.name("homepage"), contactData.getHomepage());
//        select(By.name("bday"), contactData.getDayOfBirthday());
//        select(By.name("bmonth"), contactData.getMonthOfBirthday());
//        type(By.name("byear"), contactData.getYearOfBirthday());
//    }
    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void deleteSelectedContacts() {
        click(By.cssSelector("[value=Delete]"));
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
        //click(By.name("selected[]"));
    }

    public void confirmDeletion(){
        confirmAlert();
    }

    public void initContactModification(int index) {
        driver.findElements(By.cssSelector("[title=Edit]")).get(index).click();
        //click(By.cssSelector("[title=Edit]"));
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

    public void modify(int index, ContactData contact) {
        initContactModification(index);
        fillInContactForm(contact, false);
        submitContactModification();
        returnToHomePage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContacts();
        confirmDeletion();
    }

    public boolean isThereNoContact() {
        return !isElementPresent(By.name("selected[]"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element: elements) {
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, firstName, lastName);
            contacts.add(contact);
        }
        return contacts;
    }
}
