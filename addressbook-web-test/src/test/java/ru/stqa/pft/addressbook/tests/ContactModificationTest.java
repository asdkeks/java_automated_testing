package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification(){
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData("Test First_name", "Test Middle_Name", "Test Last_name",
                    "Test Nickname", "Test Title", "Test Company", "Test Address",
                    "1234567788", "1234568899", "1234569900",
                    "123", "test@email.test", "test2@email.test", "test3@email.test",
                    "Test", "12", "April", "2000", "test1"), true);
        }
        List<ContactData> before = app.contact().list();
        int index = before.size()-2;
        ContactData contact = new ContactData(before.get(index).getId(),"Updated First_name", "Updated Last_name");
        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);

        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
