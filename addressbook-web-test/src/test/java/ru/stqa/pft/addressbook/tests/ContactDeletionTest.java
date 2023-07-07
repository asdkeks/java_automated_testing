package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTest extends TestBase{
    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().goToHomePage();
        if (app.getContactHelper().isThereNoContact()) {
            app.getContactHelper().createContact(new ContactData("Test First_name", "Test Middle_Name", "Test Last_name",
                    "Test Nickname", "Test Title", "Test Company", "Test Address",
                    "1234567788", "1234568899", "1234569900",
                    "123", "test@email.test", "test2@email.test", "test3@email.test",
                    "Test", "12", "April", "2000", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(0);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().confirmDeletion();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()-1);
        before.remove(0);
        Assert.assertEquals(after, before);
    }
}
