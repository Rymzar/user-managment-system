package com.example.usermanagment.testingweb;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.usermanagment.rest_controllers.RegisterApiController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmokeTest {

    @Autowired
    private RegisterApiController registerApiController;

    @Test
    void contextLoads() throws Exception {
        assertThat(registerApiController).isNotNull();
    }
}
