package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test1", "test2", "test3");
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size()+1);

        int max = 0;
        for (GroupData gr: after) {
            if (gr.getId() > max) {
             max = gr.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
//        app.getGroupHelper().initGroupCreation();
//        app.getGroupHelper().fillInGroupForm(new GroupData("test1", null, null));
//        app.getGroupHelper().submitGroupCreation();
//        app.getNavigationHelper().goToGroupPage();
    }

}

