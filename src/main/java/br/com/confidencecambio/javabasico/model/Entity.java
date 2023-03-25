package br.com.confidencecambio.javabasico.model;

import java.util.Arrays;

public class Entity {

	private String nome;

	public Entity(String nome) {
		if (!validateName(nome)) {
			throw new IllegalArgumentException(
					"Name cannot be null/empty or have blank spaces at the beginning or end.");
		}
		this.nome = nome.trim();
	}

	private boolean validateName(String nome) {
		return nome != null && !nome.isBlank() && !nome.trim().isEmpty() && nome.equals(nome.trim());
	}

	public String getFirstName() {
		String[] nomes = nome.split(" ");
		return nomes[0];
	}

	public String getLastName() {
		String[] nomes = nome.split(" ");
		if (nomes.length > 1) {
			return String.join(" ", Arrays.copyOfRange(nomes, 1, nomes.length));
		}

		return "";
	}

	public String getFullNameInUpperCase() {
		return nome.toUpperCase();
	}

	public String getAbbreviatedName() {
		String[] nomes = nome.split(" ");
		StringBuilder abreviado = new StringBuilder(nomes[0]);

		for (int i = 1; i < nomes.length; i++) {
			String nomeAtual = nomes[i];
			if (i == nomes.length - 1) { // último nome
				abreviado.append(" ").append(nomeAtual);
			} else if (nomeAtual.length() > 2) {
				abreviado.append(" ").append(nomeAtual.charAt(0)).append(".");
			} else {
				abreviado.append(" ").append(nomeAtual);
			}
		}

		return abreviado.toString();
	}
}