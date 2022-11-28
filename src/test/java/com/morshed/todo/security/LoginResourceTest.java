package com.morshed.todo.security;

import com.morshed.todo.TodoPostgresqlContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
@ActiveProfiles("testcontainers")
public class LoginResourceTest {
    @Container
    public static TodoPostgresqlContainer container = TodoPostgresqlContainer.getInstance();
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void shouldReturnToken() throws Exception{
        this.mockMvc.perform(post("/api/login")
                .with(httpBasic("monjurmorshed793@gmail.com","123456"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());

    }

    @Test
    public void shouldThrowUnauthorizedStatus() throws Exception{
        this.mockMvc.perform(post("/api/login")
                        .with(httpBasic("monjurmorshed793@gmail.com","12345"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(401));
    }

}
