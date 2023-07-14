package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactInfoPageTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirst_name("Test First_name").withMiddle_name("Test Middle_Name")
                    .withLast_name("Test Last_name").withNickname("Test Nickname").withTitle("Test Title")
                    .withCompany("Test Company").withAddress("Test Address").withHome_telephone("1234567788")
                    .withMobile_telephone("1234568899").withWork_telephone("1234569900").withFax_telephone("123")
                    .withEmail("test@email.test").withEmail2("test2@email.test").withEmail3("test3@email.test")
                    .withHomepage("Test").withDayOfBirthday("12").withMonthOfBirthday("April").withYearOfBirthday("2000")
                    .withGroup("test1"), true);
        }
    }

    @Test
    public void testContactInfoPage(){
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditPage = app.contact().getInfoFromEditPage(contact);
        app.goTo().homePage();
        String contactDataFromInfoPage =  app.contact().getDataFromInfoPage(contact);

        assertThat(contactDataFromInfoPage, equalTo(toInfoPage(contactInfoFromEditPage)));
    }

    private String toInfoPage(ContactData contact) {
        String result = contact.getFirst_name() + " " + contact.getMiddle_name() + " " + contact.getLast_name() + "\n" +
                contact.getNickname() + "\n" + contact.getTitle() + "\n" + contact.getCompany() + "\n" +
                contact.getAddress() + "\n\n" + "H: " + contact.getHome_telephone() + "\n" + "M: " +
                contact.getMobile_telephone() + "\nW: " + contact.getWork_telephone() + "\nF: " +
                contact.getFax_telephone() + "\n\n" + "Homepage:\n" + contact.getHomepage() + "\n\n" + "Birthday " +
                contact.getDayOfBirthday() + ". " + contact.getMonthOfBirthday() + " " + contact.getYearOfBirthday() +
                " (23)" + "\n\nMember of: test1";
        return result;
    }
}
