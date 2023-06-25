package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillInEditContactForm(
                new ContactData("Updated First_name", "Updated Middle_Name", "Updated Last_name",
                        "Updated Nickname", "Updated Title", "Updated Company", "Updated Address",
                        "1234567788", "1234568899", "1234569900",
                        "123", "test@email.test", "test2@email.test", "test3@email.test",
                        "Test", "12", "April", "2000"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
    }
}
