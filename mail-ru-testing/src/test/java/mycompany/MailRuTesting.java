package mycompany;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class MailRuTesting {

    @Before
    public void  setup() {
        //Configuration.browser = "firefox";
        //Configuration.browser = "opera";
        //Configuration.browser = "edge";
        Configuration.timeout = 30000;
        Configuration.startMaximized = true;
    }

    @Test
    public void userOpenPage() {
        //Открытие браузера по умолчанию
        open("https://mail.ru/");

        //Переход на страницу почты
        $x("//*[@id='ph-whiteline']/div/div[1]/a[2]").click();

        //Авторизация в почте
        $("input[name='username']").setValue("testing-mailbox");
        $("div[class='box-0-2-119 activeBox-0-2-124']").click();
        $("span[class='inner-0-2-89 innerTextWrapper-0-2-90']").click();
        $("input[name='password']").setValue("testing12345");
        $("path[fill-rule='evenodd']").click();
        $("span[class='inner-0-2-89 innerTextWrapper-0-2-90']").click();

        //Написать письмо себе
        $("div[class='compose-dropdown']").shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        $(byText("Написать себе")).click();
        $("input[class='container--H9L5q size_s--3_M-_'][type='text'][name='Subject'][tabindex='400'][value]").setValue("Letter for me");
        $x("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]").setValue("Hello");
        $x("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span/span").click();
    }
}