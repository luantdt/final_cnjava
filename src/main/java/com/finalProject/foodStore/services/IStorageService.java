package com.finalProject.foodStore.services;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
	public String storeFile(MultipartFile file);

	public Stream<Path> loadAll(); // load all file inside a folder

	public byte[] readFileContent(String fileName);

	public boolean deleteFile(String fileName);
}
