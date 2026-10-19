package com.a01.acortador.nginx_links;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class NginxLinksApplicationTests {

	@Test
	void contextLoads() {
	}

}
