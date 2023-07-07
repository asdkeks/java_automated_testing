package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation(){
        app.getNavigationHelper().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreation();
        ContactData contact = new ContactData("Test First_name", "Test Middle_Name", "Test Last_name",
                "Test Nickname", "Test Title", "Test Company", "Test Address",
                "1234567788", "1234568899", "1234569900",
                "123", "test@email.test", "test2@email.test", "test3@email.test",
                "Test", "12", "April", "2000", "test1");
        app.getContactHelper().fillInContactForm(contact, true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()+1);
        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

//        app.getContactHelper().createContact(new ContactData("Test First_name", "Test Middle_Name", "Test Last_name",
//                        "Test Nickname", "Test Title", "Test Company", "Test Address",
//                        "1234567788", "1234568899", "1234569900",
//                        "123", "test@email.test", "test2@email.test", "test3@email.test",
//                        "Test", "12", "April", "2000", "test1"), true);
    }
}
