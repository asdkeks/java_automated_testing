package ru.stqa.pft.addressbook.model;


import java.util.Objects;

public class ContactData {

    private int id = Integer.MAX_VALUE;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String nickname;
    private String title;
    private String company;
    private String address;
    private String home_telephone;
    private String mobile_telephone;
    private String work_telephone;
    private String fax_telephone;
    private String email;
    private String email2;
    private String email3;
    private String homepage;
    private String dayOfBirthday;
    private String monthOfBirthday;
    private String yearOfBirthday;
    private String group;

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
