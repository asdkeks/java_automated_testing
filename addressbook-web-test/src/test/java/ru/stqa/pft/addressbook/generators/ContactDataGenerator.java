package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter(names = "-d", description = "Data format")
    public String format;
    @Parameter(names = "-f", description = "Target file")
    public String file;
    @Parameter(names = "-c", description = "Contact count")
    public int count;
//    @Parameter(names = "p", description = "Photo")
//    public String photo;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        }else {
            System.out.println("Unrecognised format " + format);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(GroupData.class);
        String xml = xStream.toXML(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (ContactData contact:contacts) {
                writer.write(String.format(("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n"),
                        contact.getFirst_name(), contact.getMiddle_name(), contact.getLast_name(), contact.getNickname(),
                        contact.getTitle(), contact.getCompany(), contact.getAddress(), contact.getHome_telephone(),
                        contact.getMobile_telephone(), contact.getWork_telephone(), contact.getFax_telephone(),
                        contact.getEmail(), contact.getEmail2(), contact.getEmail3(), contact.getHomepage(),
                        contact.getDayOfBirthday(), contact.getMonthOfBirthday(), contact.getYearOfBirthday(),
                        contact.getGroup()));
            }
        }
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        LocalDate today = LocalDate.now();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirst_name(String.format("First_name %s, %s", today, i))
                    .withMiddle_name(String.format("Middle_Name %s", i)).withLast_name(String.format("Last_Name %s", i))
                    .withNickname(String.format("Nickname %s", i)).withTitle(String.format("Title %s", i))
                    .withCompany(String.format("Company %s", i)).withAddress(String.format("Address %s", i))
                    .withHome_telephone("1234567788").withMobile_telephone("1234568899").withWork_telephone("1234569900")
                    .withFax_telephone("123").withEmail("test@email.test").withEmail2("test2@email.test")
                    .withEmail3("test3@email.test").withHomepage("Test").withDayOfBirthday("12")
                    .withMonthOfBirthday("April").withYearOfBirthday("2000").withGroup("test1"));
        }
        return contacts;
    }
}
