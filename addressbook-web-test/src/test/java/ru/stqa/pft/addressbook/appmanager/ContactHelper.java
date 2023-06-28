package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation(){
        click(By.linkText("add new"));
    }
    public void fillInContactForm(ContactData contactData, boolean creation) {
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
        if (creation){
            select(By.name("new_group"), contactData.getGroup());
        } else {
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

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void confirmDeletion(){
        confirmAlert();
    }

    public void initContactModification() {
        click(By.cssSelector("[title=Edit]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }
}
