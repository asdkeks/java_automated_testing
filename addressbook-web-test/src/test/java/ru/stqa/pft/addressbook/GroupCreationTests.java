package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        goToGroupPage();
        initGroupCreation();
        fillInGroupForm(new GroupDelta("test1", "test2", "test3"));
        submitGroupCreation();
        goToGroupPage();
    }

}

