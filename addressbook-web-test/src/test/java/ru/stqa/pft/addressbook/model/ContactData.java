package ru.stqa.pft.addressbook.model;


import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

public class ContactData {

    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    @Expose
    private String first_name;
    @Expose
    private String middle_name;
    @Expose
    private String last_name;
    @Expose
    private String nickname;
    @Expose
    private String title;
    @Expose
    private String company;
    @Expose
    private String address;
    @Expose
    private String home_telephone;
    @Expose
    private String mobile_telephone;
    @Expose
    private String work_telephone;
    @Expose
    private String fax_telephone;
    @Expose
    private String email;
    @Expose
    private String email2;
    @Expose
    private String email3;
    @Expose
    private String homepage;
    @Expose
    private String dayOfBirthday;
    @Expose
    private String monthOfBirthday;
    @Expose
    private String yearOfBirthday;
    @Expose
    private String group;
    @Expose
    private String allPhones;
    @Expose
    private String allEmails;
    @Expose
    private String dayOfAnniversary;
    @Expose
    private String monthOfAnniversary;
    @Expose
    private String yearOfAnniversary;
    @Expose
    private String secondAddress;
    @Expose
    private File photo;

    public String getDayOfAnniversary() {
        return dayOfAnniversary;
    }

    public String getMonthOfAnniversary() {
        return monthOfAnniversary;
    }

    public String getYearOfAnniversary() {
        return yearOfAnniversary;
    }


    public String getSecondAddress() {
        return secondAddress;
    }


    public String getSecondHomePhone() {
        return secondHomePhone;
    }


    public String getNotes() {
        return notes;
    }


    private String secondHomePhone;
    private String notes;


    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome_telephone() {
        return home_telephone;
    }

    public String getMobile_telephone() {
        return mobile_telephone;
    }

    public String getWork_telephone() {
        return work_telephone;
    }

    public String getFax_telephone() {
        return fax_telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getDayOfBirthday() {
        return dayOfBirthday;
    }

    public String getMonthOfBirthday() {
        return monthOfBirthday;
    }

    public String getYearOfBirthday() {
        return yearOfBirthday;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public File getPhoto() {
        return photo;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public ContactData withMiddle_name(String middle_name) {
        this.middle_name = middle_name;
        return this;
    }

    public ContactData withLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHome_telephone(String home_telephone) {
        this.home_telephone = home_telephone;
        return this;
    }

    public ContactData withMobile_telephone(String mobile_telephone) {
        this.mobile_telephone = mobile_telephone;
        return this;
    }

    public ContactData withWork_telephone(String work_telephone) {
        this.work_telephone = work_telephone;
        return this;
    }

    public ContactData withFax_telephone(String fax_telephone) {
        this.fax_telephone = fax_telephone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public ContactData withDayOfBirthday(String dayOfBirthday) {
        this.dayOfBirthday = dayOfBirthday;
        return this;
    }

    public ContactData withMonthOfBirthday(String monthOfBirthday) {
        this.monthOfBirthday = monthOfBirthday;
        return this;
    }

    public ContactData withYearOfBirthday(String yearOfBirthday) {
        this.yearOfBirthday = yearOfBirthday;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withDayOfAnniversary(String dayOfAnniversary) {
        this.dayOfAnniversary = dayOfAnniversary;
        return this;
    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ContactData withSecondHomePhone(String secondHomePhone) {
        this.secondHomePhone = secondHomePhone;
        return this;
    }

    public ContactData withMonthOfAnniversary(String monthOfAnniversary) {
        this.monthOfAnniversary = monthOfAnniversary;
        return this;
    }

    public ContactData withSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
        return this;
    }

    public ContactData withYearOfAnniversary(String yearOfAnniversary) {
        this.yearOfAnniversary = yearOfAnniversary;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (!Objects.equals(first_name, that.first_name)) return false;
        return Objects.equals(last_name, that.last_name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        return result;
    }



}
