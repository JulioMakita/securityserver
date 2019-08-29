package com.juliomakita.securityserver;

import com.juliomakita.securityserver.com.juliomakita.securityserver.controller.HomeController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = HomeController.class)
public class HomeControllerTest {
}
