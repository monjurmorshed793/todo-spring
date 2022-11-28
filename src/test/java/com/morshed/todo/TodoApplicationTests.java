package com.morshed.todo;

import com.morshed.todo.user.management.repository.UserRepository;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@ActiveProfiles("testcontainers")
class TodoApplicationTests {

	@Container
	public static TodoPostgresqlContainer container = TodoPostgresqlContainer.getInstance();

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		var countLong = userRepository.count();
	}

}
