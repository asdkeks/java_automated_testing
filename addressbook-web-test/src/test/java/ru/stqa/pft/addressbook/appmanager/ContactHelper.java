package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation(){
        click(By.linkText("add new"));
    }
    public void fillInContactForm(ContactData contact, boolean creation) {
            if (creation){
                type(By.name("firstname"), contact.getFirst_name());
                type(By.name("middlename"), contact.getMiddle_name());
                type(By.name("lastname"), contact.getLast_name());
                type(By.name("nickname"), contact.getNickname());
                type(By.name("title"), contact.getTitle());
                type(By.name("company"), contact.getCompany());
                type(By.name("address"), contact.getAddress());
                type(By.name("home"), contact.getHome_telephone());
                type(By.name("mobile"), contact.getMobile_telephone());
                type(By.name("work"), contact.getWork_telephone());
                type(By.name("fax"), contact.getFax_telephone());
                type(By.name("email"), contact.getEmail());
                type(By.name("email2"), contact.getEmail2());
                type(By.name("email3"), contact.getEmail3());
                type(By.name("homepage"), contact.getHomepage());
                selectByText(By.name("bday"), contact.getDayOfBirthday());
                selectByText(By.name("bmonth"), contact.getMonthOfBirthday());
                type(By.name("byear"), contact.getYearOfBirthday());
                selectByText(By.name("new_group"), contact.getGroups().iterator().next().getName());
                attach(By.name("photo"), contact.getPhoto());
            } else {
                type(By.name("firstname"), contact.getFirst_name());
                type(By.name("lastname"), contact.getLast_name());
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

    private String getAllEmails(List<WebElement> mails) {
        return mails.stream().map(WebElement::getText).collect(Collectors.joining("\n"));
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
            String allEmails = getAllEmails(element.findElement(By.cssSelector("td:nth-child(5)")).findElements(By.tagName("a")));
            String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirst_name(firstName).withLast_name(lastName)
                    .withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails);
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }

    public ContactData getInfoFromEditPage(ContactData contact){
        editPage(contact.getId());
        String firstName = driver.findElement(By.name("firstname")).getAttribute("value");
        String middleName = driver.findElement(By.name("middlename")).getAttribute("value");
        String lastName = driver.findElement(By.name("lastname")).getAttribute("value");
        String homePhone = driver.findElement(By.name("home")).getAttribute("value");
        String mobilePhone = driver.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = driver.findElement(By.name("work")).getAttribute("value");
        String fax = driver.findElement(By.name("fax")).getAttribute("value");
        String email = driver.findElement(By.name("email")).getAttribute("value");
        String email2 = driver.findElement(By.name("email2")).getAttribute("value");
        String email3 = driver.findElement(By.name("email3")).getAttribute("value");
        String address = driver.findElement(By.name("address")).getText();
        String nickname = driver.findElement(By.name("nickname")).getAttribute("value");
        String title = driver.findElement(By.name("title")).getAttribute("value");
        String company = driver.findElement(By.name("company")).getAttribute("value");
        String homepage = driver.findElement(By.name("homepage")).getAttribute("value");
        String dayOfBirthday = driver.findElement(By.name("bday")).
                findElement(By.cssSelector("[selected=\"selected\"]")).getAttribute("value");
        String monthOfBirthday = driver.findElement(By.name("bmonth")).
                findElement(By.cssSelector("[selected=\"selected\"]")).getText();
        String yearOfBirthday = driver.findElement(By.name("byear")).getAttribute("value");
        String dayOfAnniversary;
        if (! driver.findElement(By.name("aday")).
                findElement(By.cssSelector("[selected=\"selected\"]")).getAttribute("value").equals("0")) {
            dayOfAnniversary = driver.findElement(By.name("ayear")).getAttribute("value");
        } else {
            dayOfAnniversary = "";
        }
        String monthOfAnniversary ;
        if (! driver.findElement(By.name("amonth")).
                findElement(By.cssSelector("[selected=\"selected\"]")).getText().equals("-")) {
            monthOfAnniversary = driver.findElement(By.name("ayear")).getAttribute("value");
        } else {
            monthOfAnniversary = "";
        }
        String yearOfAnniversary = driver.findElement(By.name("ayear")).getAttribute("value");
        String secondAddress = driver.findElement(By.name("address2")).getText();
        String secondPhone = driver.findElement(By.name("phone2")).getAttribute("value");
        String notes = driver.findElement(By.name("notes")).getText();
        return new ContactData().withId(contact.getId()).withFirst_name(firstName).withLast_name(lastName).
                withHome_telephone(homePhone).withMobile_telephone(mobilePhone).withWork_telephone(workPhone).
                withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address).
                withNickname(nickname).withTitle(title).withCompany(company).withHomepage(homepage).
                withDayOfBirthday(dayOfBirthday).withMonthOfBirthday(monthOfBirthday).
                withYearOfBirthday(yearOfBirthday).withFax_telephone(fax).withMiddle_name(middleName).
                withSecondAddress(secondAddress).withSecondHomePhone(secondPhone).withNotes(notes).
                withDayOfAnniversary(dayOfAnniversary).withMonthOfAnniversary(monthOfAnniversary).
                withYearOfAnniversary(yearOfAnniversary);
    }

    private void infoPage(int id) {
        click(By.cssSelector(String.format("[href=\"view.php?id=%s\"", id)));
    }
    public String getDataFromInfoPage(ContactData contact) {
        infoPage(contact.getId());
        String dataFromInfoPage = driver.findElement(By.id("content")).getText();
        return dataFromInfoPage.replaceAll("\\. ", "").replaceAll("\\s", "")
                .replaceAll("H:", "").replaceAll("M:", "")
                .replaceAll("W:", "").replaceAll("F:", "")
                .replaceAll("Homepage:", "").replaceAll("Birthday", "")
                .replaceAll("Memberof:", "").replaceAll("(\\(..\\))", "")
                .replaceAll("Anniversary", "").replaceAll("P:", "");
    }

    public void waitContact(int sec){
        wait(sec);
    }

    public void refreshHomePage() {
        refresh();
    }

    public void addInGroup(ContactData contact, GroupData group) {
        selectContactById(contact.getId());
        selectByValue(By.name("to_group"), String.valueOf(group.getId()));
        click(By.name("add"));
    }

    public void deleteFromGroup(ContactData contact, GroupData group) {
        selectByValue(By.name("group"), String.valueOf(group.getId()));
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(String.valueOf(contact.getId()))));
        selectContactById(contact.getId());
        click(By.name("remove"));
    }
}

