package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/contacts.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xStream = new XStream();
            xStream.processAnnotations(GroupData.class);
            Class<?>[] classes = new Class[] {GroupData.class};
            xStream.allowTypes(classes);
            List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
            return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {

                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            //kind of List<ContactData>.class, but it doesn't work with lists
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
            return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactData contact){
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("./src/test/resources/test.png");
//        ContactData contact = new ContactData().withFirst_name("Test First_name").withMiddle_name("Test Middle_Name")
//                .withLast_name("Test Last_name").withNickname("Test Nickname").withTitle("Test Title")
//                .withCompany("Test Company").withAddress("Test Address").withHome_telephone("1234567788")
//                .withMobile_telephone("1234568899").withWork_telephone("1234569900").withFax_telephone("123")
//                .withEmail("test@email.test").withEmail2("test2@email.test").withEmail3("test3@email.test")
//                .withHomepage("Test").withDayOfBirthday("12").withMonthOfBirthday("April").withYearOfBirthday("2000")
//                .withGroup("test1").withPhoto(photo);
        app.contact().create(contact.withPhoto(photo), true);
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((с) -> с.getId()).max().getAsInt()))));
    }


}
