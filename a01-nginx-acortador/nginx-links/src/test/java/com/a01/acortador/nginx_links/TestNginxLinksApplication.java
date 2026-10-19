package com.a01.acortador.nginx_links;

import org.springframework.boot.SpringApplication;

public class TestNginxLinksApplication {

	public static void main(String[] args) {
		SpringApplication.from(NginxLinksApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
