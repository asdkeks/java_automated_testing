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

    public void editPage(int id) {
        driver.findElement(By.cssSelector("[href=\"edit.php?id=" + id + "\"]" )).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void create(ContactData contact, Boolean isCreation) {
        initContactCreation();
        fillInContactForm(contact, isCreation);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        editPage(contact.getId());
        fillInContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        contactCache = null;
        confirmDeletion();
    }



    public boolean isThereNoContact() {
        return !isElementPresent(By.name("selected[]"));
    }

    public int count(){
        return driver.findElements(By.name("entry")).size();
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }


    private Contacts contactCache = null;
    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element: elements) {
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirst_name(firstName).withLast_name(lastName)
                    .withAllPhones(allPhones);
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }

    public ContactData getInfoFromEditPage(ContactData contact){
        editPage(contact.getId());
        String firstName = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastName = driver.findElement(By.name("lastname")).getAttribute("value");
        String homePhone = driver.findElement(By.name("home")).getAttribute("value");
        String MobilePhone = driver.findElement(By.name("mobile")).getAttribute("value");
        String WorkPhone = driver.findElement(By.name("work")).getAttribute("value");
        return new ContactData().withId(contact.getId()).withFirst_name(firstName).withLast_name(lastName).
                withHome_telephone(homePhone).withMobile_telephone(MobilePhone).withWork_telephone(WorkPhone);
    }
}
