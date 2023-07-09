package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation(){
        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData().withFirst_name("Test First_name").withMiddle_name("Test Middle_Name")
                .withLast_name("Test Last_name").withNickname("Test Nickname").withTitle("Test Title")
                .withCompany("Test Company").withAddress("Test Address").withHome_telephone("1234567788")
                .withMobile_telephone("1234568899").withWork_telephone("1234569900").withFax_telephone("123")
                .withEmail("test@email.test").withEmail2("test2@email.test").withEmail3("test3@email.test")
                .withHomepage("Test").withDayOfBirthday("12").withMonthOfBirthday("April").withYearOfBirthday("2000")
                .withGroup("test1");
        app.contact().create(contact, true);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size()+1);
        contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
