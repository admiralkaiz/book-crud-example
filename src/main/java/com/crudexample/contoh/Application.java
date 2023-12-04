package com.crudexample.contoh;

import com.crudexample.contoh.entity.Book;
import com.crudexample.contoh.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		Book book1 = new Book("978-979-29-9086-7",
				              "Sistem Operasi, Konsep Dan Membuat Linux OpenWRT Dan ROM Android",
							  "Onno W. Purbo",
				              "Penerbit Andi",
							  "2019");
		bookRepository.save(book1);

		Book book2 = new Book("979-533-863-3",
				"Pengenalan Unix Dan Linux",
				"Abdul Kadir",
				"Penerbit Andi",
				"2002");
		bookRepository.save(book2);

		Book book3 = new Book("979-533-887-0",
				"Python dan Pemrograman Linux",
				"Noprianto",
				"Penerbit Andi",
				"2002");
		bookRepository.save(book3);
		*/
	}
}
