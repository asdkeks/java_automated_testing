package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

public class DeleteContactFromGroupTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirst_name("Test First_name").withMiddle_name("Test Middle_Name")
                            .withLast_name("Test Last_name").withNickname("Test Nickname").withTitle("Test Title")
                            .withCompany("Test Company").withAddress("Test Address").withHome_telephone("1234567788")
                            .withMobile_telephone("1234568899").withWork_telephone("1234569900").withFax_telephone("123")
                            .withEmail("test@email.test").withEmail2("test2@email.test").withEmail3("test3@email.test")
                            .withHomepage("Test").withDayOfBirthday("12").withMonthOfBirthday("April").withYearOfBirthday("2000")
                    , true);
        }
        if (app.db().groups().size() == 0) {
            app.group().create(new GroupData().withName("ADD").withHeader("IN").withFooter("ME"));
        }
    }


    @Test
    public void testDeleteContactFromGroup(){
        ContactData contact = app.db().contacts().iterator().next();
        GroupData group;
        if (contact.getGroups().size() == 0) {
            group = app.db().groups().iterator().next();
            app.contact().addInGroup(contact, group);
            app.goTo().homePage();
        } else
        {
            group = contact.getGroups().iterator().next();
        }
        app.contact().deleteFromGroup(contact, group);
        app.goTo().homePage();
        contact = app.db().contacts().iterator().next();
        group = app.db().groups().iterator().next();
        Assert.assertFalse(contact.getGroups().contains(group));
        Assert.assertFalse(group.getContacts().contains(contact));
    }
}
