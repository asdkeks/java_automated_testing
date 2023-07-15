package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation(){
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("./src/test/resources/test.png");
        ContactData contact = new ContactData().withFirst_name("Test First_name").withMiddle_name("Test Middle_Name")
                .withLast_name("Test Last_name").withNickname("Test Nickname").withTitle("Test Title")
                .withCompany("Test Company").withAddress("Test Address").withHome_telephone("1234567788")
                .withMobile_telephone("1234568899").withWork_telephone("1234569900").withFax_telephone("123")
                .withEmail("test@email.test").withEmail2("test2@email.test").withEmail3("test3@email.test")
                .withHomepage("Test").withDayOfBirthday("12").withMonthOfBirthday("April").withYearOfBirthday("2000")
                .withGroup("test1").withPhoto(photo);
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((с) -> с.getId()).max().getAsInt()))));
    }


}
