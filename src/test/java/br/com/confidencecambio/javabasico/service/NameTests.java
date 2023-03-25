package br.com.confidencecambio.javabasico.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.confidencecambio.javabasico.model.Client;
import br.com.confidencecambio.javabasico.model.Entity;
import br.com.confidencecambio.javabasico.model.Manager;
import br.com.confidencecambio.javabasico.model.Robot;

public class NameTests {

	@Test
	public void testNameCannotBeNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Entity(null);
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Client(null);
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Manager(null);
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Robot(null);
		});
	}

	@Test
	public void testNameCannotBeEmpty() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Entity("");
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Client("");
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Manager("");
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Robot("");
		});
	}

	@Test
	public void testNameCannotHaveExtraSpaces() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Entity(" João  Soares  Silva");
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Client(" Josê Felipe Suarez ");
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Manager(" Ana    Clara  Souza   ");
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Robot("   Robô  Maquina  Teste  ");
		});
	}

	@Test
	public void testGetFirstName() {
		Entity entity = new Entity("João Soares Silva");
		Assertions.assertEquals("João", entity.getFirstName());

		Client client = new Client("Josê Felipe Suarez");
		Assertions.assertEquals("Josê", client.getFirstName());

		Manager manager = new Manager("Ana Clara Souza");
		Assertions.assertEquals("Ana", manager.getFirstName());

		Robot robot = new Robot("Robô de Teste");
		Assertions.assertEquals("Robô", robot.getFirstName());
	}

	@Test
	public void testGetLastNames() {
		Entity entity = new Entity("João Soares Silva");
		Assertions.assertEquals("Soares Silva", entity.getLastName());

		Client client = new Client("Josê Felipe Suarez");
		Assertions.assertEquals("Felipe Suarez", client.getLastName());

		Manager manager = new Manager("Ana Clara Souza");
		Assertions.assertEquals("Clara Souza", manager.getLastName());

		Robot robot = new Robot("Robô Maquina Teste");
		Assertions.assertEquals("Maquina Teste", robot.getLastName());
	}

	@Test
	public void testGetFullNameInUpperCase() {
		Entity entity = new Entity("João Soares Silva");
		Assertions.assertEquals("JOÃO SOARES SILVA", entity.getFullNameInUpperCase());

		Client client = new Client("Josê Felipe Suarez");
		Assertions.assertEquals("JOSÊ FELIPE SUAREZ", client.getFullNameInUpperCase());

		Manager manager = new Manager("Ana Clara Souza");
		Assertions.assertEquals("ANA CLARA SOUZA", manager.getFullNameInUpperCase());

		Robot robot = new Robot("Robô Maquina Teste");
		Assertions.assertEquals("ROBÔ MAQUINA TESTE", robot.getFullNameInUpperCase());
	}

	@Test
	public void testGetAbbreviatedName() {
		Entity entity = new Entity("João Soares Silva");
		Assertions.assertEquals("João S. Silva", entity.getAbbreviatedName());

		Client client = new Client("Josê Felipe Suarez");
		Assertions.assertEquals("Josê F. Suarez", client.getAbbreviatedName());

		Manager manager = new Manager("Ana Clara Souza");
		Assertions.assertEquals("Ana C. Souza", manager.getAbbreviatedName());

		Robot robot = new Robot("Robô Maquina Teste");
		Assertions.assertEquals("Robô M. Teste", robot.getAbbreviatedName());
	}
}
