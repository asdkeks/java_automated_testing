package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase{

    @Test
    public void testContactAddress(){
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditPage = app.contact().getInfoFromEditPage(contact);

        assertThat(contact.getAddress(), equalTo((contactInfoFromEditPage.getAddress())));
        }
}
