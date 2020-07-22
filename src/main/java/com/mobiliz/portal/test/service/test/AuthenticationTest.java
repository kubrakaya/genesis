package com.mobiliz.portal.test.service.test;

import com.mobiliz.portal.test.service.rest.WebServiceMethods;
import org.testng.annotations.Test;

public class AuthenticationTest {

    WebServiceMethods webServiceMethods = new WebServiceMethods();

    @Test
    public void VerifyThat_Post_Login_UserLogin_Works_Successfully() {

        webServiceMethods.post_Login_UserLogin_2Parameters();

    }

}
