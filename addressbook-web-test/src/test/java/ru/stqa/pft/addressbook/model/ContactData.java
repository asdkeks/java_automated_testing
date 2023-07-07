package ru.stqa.pft.addressbook.model;


import java.util.Objects;

public class ContactData {

    private int id;
    private final String first_name;
    private final String middle_name;
    private final String last_name;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String home_telephone;
    private final String mobile_telephone;
    private final String work_telephone;
    private final String fax_telephone;
    private final String email;
    private final String email2;
    private final String email3;
    private final String homepage;
    private final String dayOfBirthday;
    private final String monthOfBirthday;
    private final String yearOfBirthday;
    private String group;

    public ContactData(String first_name, String middle_name, String last_name, String nickname, String title,
                       String company, String address, String home_telephone, String mobile_telephone,
                       String work_telephone, String fax_telephone, String email, String email2,
                       String email3, String homepage, String dayOfBirthday, String monthOfBirthday,
                       String yearOfBirthday, String group){
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home_telephone = home_telephone;
        this.mobile_telephone = mobile_telephone;
        this.work_telephone = work_telephone;
        this.fax_telephone = fax_telephone;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.dayOfBirthday = dayOfBirthday;
        this.monthOfBirthday = monthOfBirthday;
        this.yearOfBirthday = yearOfBirthday;
        this.group = group;
        this.id = 0;
    }

    public ContactData(int id, String first_name, String last_name
                       ){
        this.id = id;
        this.first_name = first_name;
        this.middle_name = null;
        this.last_name = last_name;
        this.nickname = null;
        this.title = null;
        this.company = null;
        this.address = null;
        this.home_telephone = null;
        this.mobile_telephone = null;
        this.work_telephone = null;
        this.fax_telephone = null;
        this.email = null;
        this.email2 = null;
        this.email3 = null;
        this.homepage = null;
        this.dayOfBirthday = null;
        this.monthOfBirthday = null;
        this.yearOfBirthday = null;
        this.group = null;
    }

//    public ContactData(String first_name, String middle_name, String last_name, String nickname, String title,
//                       String company, String address, String home_telephone, String mobile_telephone,
//                       String work_telephone, String fax_telephone, String email, String email2,
//                       String email3, String homepage, String dayOfBirthday, String monthOfBirthday,
//                       String yearOfBirthday){
//        this.first_name = first_name;
//        this.middle_name = middle_name;
//        this.last_name = last_name;
//        this.nickname = nickname;
//        this.title = title;
//        this.company = company;
//        this.address = address;
//        this.home_telephone = home_telephone;
//        this.mobile_telephone = mobile_telephone;
//        this.work_telephone = work_telephone;
//        this.fax_telephone = fax_telephone;
//        this.email = email;
//        this.email2 = email2;
//        this.email3 = email3;
//        this.homepage = homepage;
//        this.dayOfBirthday = dayOfBirthday;
//        this.monthOfBirthday = monthOfBirthday;
//        this.yearOfBirthday = yearOfBirthday;
//    }
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

    public void setId(int id) {
        this.id = id;
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

        if (!Objects.equals(first_name, that.first_name)) return false;
        return Objects.equals(last_name, that.last_name);
    }

    @Override
    public int hashCode() {
        int result = first_name != null ? first_name.hashCode() : 0;
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        return result;
    }
}
