package ru.stqa.pft.addressbook.model;


public class ContactData {

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
    private final String group;

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
    }

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
}
