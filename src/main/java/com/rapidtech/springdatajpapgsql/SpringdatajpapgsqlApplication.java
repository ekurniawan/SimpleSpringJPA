package com.rapidtech.springdatajpapgsql;

import com.rapidtech.springdatajpapgsql.model.Book;
import com.rapidtech.springdatajpapgsql.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringdatajpapgsqlApplication implements CommandLineRunner {

	private final Logger LOG =
			LoggerFactory.getLogger(SpringdatajpapgsqlApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpapgsqlApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book();
		book1.setTitle("Spring Boot in Action");
		book1.setWriter("Erick Kurniawan");
		book1.setIsbn("IS-99887766");

		Book book2 = new Book();
		book2.setTitle("Spring Boot REST");
		book2.setWriter("Scott Gu");
		book2.setIsbn("IS-8877665");

		//bookRepository.save(book1);
		//bookRepository.save(book2);

		List<Book> books = bookRepository.findAll();

		LOG.info("-----> Book: "+books.get(0).getTitle());
		LOG.info("-----> Book: "+books.get(1).getTitle());

		List<Book> bookByWriter = bookRepository.findAllByWriterContaining("Erick");
		LOG.info("-----> Book by Writer : "+bookByWriter.get(0).getTitle());

		//LOG.info("----- Berhasil menyimpan: "+book1.getTitle());
		//LOG.info("----- Berhasil menyimpan: "+book2.getTitle());
	}
}
