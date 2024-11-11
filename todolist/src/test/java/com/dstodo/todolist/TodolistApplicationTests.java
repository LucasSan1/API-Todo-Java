package com.dstodo.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.dstodo.todolist.entity.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void TestCreateTodoSucess() {
		var todo = new Todo("Todo 1", "desc todo 1", false, 1);

		webTestClient
			.post()
			.uri("/todo")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].nome").isEqualTo(todo.getNome())
			.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
			.jsonPath("$[0].realizado").isEqualTo(todo.getRealizado())
			.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
		System.out.println("passou");
	}

	@Test
	void TestCreateTodoFailure() {
		webTestClient
			.post()
			.uri("/todo")
			.bodyValue(
				new Todo("", "", false, 0)
			).exchange()
			.expectStatus().isBadRequest();
	}
}