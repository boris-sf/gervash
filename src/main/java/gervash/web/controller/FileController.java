package gervash.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {

	@GetMapping
	public ModelAndView index() {
		return new ModelAndView("index", "files", Arrays.asList(dir().list()));
	}

	@ResponseBody
	@GetMapping("/{file}")
	public ResponseEntity<InputStreamResource> getFile(@PathVariable("file") String file) throws FileNotFoundException {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", file);
		return new ResponseEntity<InputStreamResource>(
				new InputStreamResource(new FileInputStream(new File(dir(), file))), headers, HttpStatus.OK);
	}

	private static File dir() {
		return new File(System.getProperty("user.dir"), "files");
	}
}