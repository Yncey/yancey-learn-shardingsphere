package com.yancey.learn;

import com.yancey.learn.model.UserInfo;
import com.yancey.learn.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SpringBootTest
public class YanceyLearnApplicationTests extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserInfoService userInfoService;

    @DataProvider(name = "selectDataProvider")
    public Object[][] selectDataProvider() {

        return new Object[][]{{
                1L
        }};
    }

    @Test(dataProvider = "selectDataProvider")
    public void testSelect(Long id) {
        UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
        System.out.println(userInfo);
    }

    @Test
    public void testInsert() {

    }

}
