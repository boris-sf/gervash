package gervash.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

	@GetMapping("/ff")
	public String hello() {
		return "GERVASH";
	}
}