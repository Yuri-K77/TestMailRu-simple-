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
    public void setup() {
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
        $x("//a[@class='ph-project svelte-1dxh3mc' and text()='Почта']").click();

        //Авторизация в почте
        $("input[name='username']").setValue("testing-mailbox");
        $("div.box-0-2-119.activeBox-0-2-124").click();
        $("button.base-0-2-87.primary-0-2-101.auto-0-2-113").click(); //span.inner-0-2-89.innerTextWrapper-0-2-90
        $("input[name='password']").setValue("testing12345");
        $("path[fill-rule='evenodd']").click();
        $("button.base-0-2-87.primary-0-2-101.auto-0-2-113").click(); //span.inner-0-2-89.innerTextWrapper-0-2-90

        //Написать письмо себе
        $("div.compose-dropdown").shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        $("div.list-item.list-item_hover-support.list-item_pure").click();
        $("input[class='container--H9L5q size_s--3_M-_'][type='text'][name='Subject'][tabindex='400'][value]").setValue("Letter for me");
        //$x("//div[@class='editable-gfix cke_editable cke_editable_inline cke_contents_true cke_show_borders' and @tabindex='505']").setValue("Hello");
        $("div.editable-9o3a.cke_editable.cke_editable_inline.cke_contents_true.cke_show_borders>div").setValue("Hello");
        $x("//span[@class='button2__txt' and text()='Отправить']").click();
    }
}