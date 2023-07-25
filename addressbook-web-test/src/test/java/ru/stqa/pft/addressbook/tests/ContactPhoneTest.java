package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase{

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
                    , true);
        }
    }
    @Test
    public void testContactPhones(){
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditPage = app.contact().getInfoFromEditPage(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditPage)));

    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHome_telephone(), contact.getMobile_telephone(), contact.getWork_telephone(),
                        contact.getSecondHomePhone()).
                stream().filter((s) -> ! s.equals("")).map(ContactPhoneTest::cleaned).
                collect(Collectors.joining("\n"));
    }

    public static String cleaned (String phone) {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
