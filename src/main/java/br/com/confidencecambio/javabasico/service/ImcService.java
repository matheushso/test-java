package br.com.confidencecambio.javabasico.service;

import org.springframework.stereotype.Service;

@Service
public class ImcService {

	public String calculateImc(String peso, String altura) {
		double pesoNum = Double.parseDouble(peso);
		double alturaNum = Double.parseDouble(altura);

		if (Double.isNaN(pesoNum) || Double.isNaN(alturaNum) || pesoNum <= 0 || alturaNum <= 0) {
			throw new NumberFormatException();
		}

		double imc = pesoNum / (alturaNum * alturaNum);
		String response = String.format("Seu IMC é: %.2f", imc);

		return response;
	}

}
