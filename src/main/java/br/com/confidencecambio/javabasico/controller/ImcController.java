package br.com.confidencecambio.javabasico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.service.ImcService;

@RestController
@RequestMapping("/api/v1/imc")
public class ImcController {

	@Autowired
	private ImcService service;

	@GetMapping
	public ResponseEntity<String> getImc(String peso, String altura) {
		try {
			String response = service.calculateImc(peso, altura);

			return ResponseEntity.ok(response);

		} catch (NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The weight/height value entered is invalid");
		}
	}
}
