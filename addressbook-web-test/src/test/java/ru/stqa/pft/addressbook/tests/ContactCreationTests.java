package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation(){
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillInContactForm(
                new ContactData("Test First_name", "Test Middle_Name", "Test Last_name",
                        "Test Nickname", "Test Title", "Test Company", "Test Address",
                        "1234567788", "1234568899", "1234569900",
                        "123", "test@email.test", "test2@email.test", "test3@email.test",
                        "Test", "12", "April", "2000", "test1"), true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
    }
}
