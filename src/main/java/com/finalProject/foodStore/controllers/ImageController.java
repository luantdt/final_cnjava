package com.finalProject.foodStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalProject.foodStore.services.IStorageService;

@Controller
@RequestMapping(path = "/image")
public class ImageController {
	@Autowired
	private IStorageService storageService;

	@GetMapping("/{fileName:.+}")
	public ResponseEntity<byte[]> readDetailFile(@PathVariable String fileName) {
		try {
			byte[] bytes = storageService.readFileContent(fileName);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		} catch (Exception exception) {
			return ResponseEntity.noContent().build();
		}
	}

}
