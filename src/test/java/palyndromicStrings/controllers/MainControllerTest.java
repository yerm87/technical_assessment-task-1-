package palyndromicStrings.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import palyndromicStrings.entity.StringEntity;
import palyndromicStrings.repo.StringRepository;
import palyndromicStrings.services.MainService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class MainControllerTest {
    @Autowired
    StringRepository repo;

    @Autowired
    MainService service;

    @Test
    public void test1(){

        String testString = "wabfbau";
        String resultString = service.createPalyndromicString(testString);

        Assert.assertEquals("fba", resultString);
    }

    @Test
    public void test2(){
        String testString = "abcdftr";
        String resultString = service.createPalyndromicString(testString);

        Assert.assertEquals("", resultString);
    }

    @Test
    public void test3(){
        String testString = "vafavgtuiutgo";
        String resultString = service.createPalyndromicString(testString);
        Assert.assertEquals("iutg", resultString);
    }

    @Test
    public void test4(){
        String testString = "gtuiutggggtnmntgo";
        String resultString = service.createPalyndromicString(testString);
        Assert.assertEquals("iutg", resultString);
    }
}
