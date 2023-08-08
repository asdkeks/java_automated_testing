package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactInfoPageTest extends TestBase {

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
    }

    @Test(enabled = false)
    public void testContactInfoPage(){
        ContactData contact = app.db().contacts().iterator().next();
        ContactData contactInfoFromEditPage = app.contact().getInfoFromEditPage(contact);
        Groups contactsGroups = contact.getGroups();
        String groups = getGroupsName(contactsGroups);
        app.goTo().homePage();
        String contactDataFromInfoPage =  app.contact().getDataFromInfoPage(contact);
        assertThat(mergeContactDataToInfoPage(contactInfoFromEditPage) + groups, equalTo(contactDataFromInfoPage));
    }

    private String getGroupsName(Groups contactsGroups) {
        List<String> groupNames = new ArrayList<>();
        for (GroupData group : contactsGroups) {
            groupNames.add(group.getName());
        }
        return groupNames.stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining()).replaceAll("\\s", "");
    }

    private String mergeContactDataToInfoPage(ContactData contact) {
        return Arrays.asList(contact.getFirst_name(), contact.getMiddle_name(), contact.getLast_name(), contact.getNickname(),
                        contact.getTitle(), contact.getCompany(), contact.getAddress(), contact.getHome_telephone(),
                        contact.getMobile_telephone(), contact.getWork_telephone(), contact.getFax_telephone(),
                        contact.getEmail(), contact.getEmail2(), contact.getEmail3(), contact.getHomepage(),
                        contact.getDayOfBirthday(), contact.getMonthOfBirthday(), contact.getYearOfBirthday(),
                        contact.getDayOfAnniversary(), contact.getMonthOfAnniversary(), contact.getYearOfAnniversary(),
                        contact.getSecondAddress(), contact.getSecondHomePhone(), contact.getNotes())
                .stream().filter((s) -> ! s.equals(""))
                .collect(Collectors.joining()).replaceAll("\\s", "");
    }
}
