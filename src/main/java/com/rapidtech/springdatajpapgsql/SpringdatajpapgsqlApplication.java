package com.rapidtech.springdatajpapgsql;

import com.rapidtech.springdatajpapgsql.model.Book;
import com.rapidtech.springdatajpapgsql.model.BookCategory;
import com.rapidtech.springdatajpapgsql.repository.BookCategoryRepository;
import com.rapidtech.springdatajpapgsql.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringdatajpapgsqlApplication implements CommandLineRunner {

	private final Logger LOG =
			LoggerFactory.getLogger(SpringdatajpapgsqlApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpapgsqlApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	@Override
	public void run(String... args) throws Exception {
		/*Book book1 = new Book();
		book1.setTitle("Spring Boot in Action");
		book1.setWriter("Erick Kurniawan");
		book1.setIsbn("IS-99887766");

		Book book2 = new Book();
		book2.setTitle("Spring Boot REST");
		book2.setWriter("Scott Gu");
		book2.setIsbn("IS-8877665");*/

		//bookRepository.save(book1);
		//bookRepository.save(book2);

		//tambah bookCategory
		/*BookCategory bookCategory1 = new BookCategory();
		bookCategory1.setName("Novel");
		BookCategory bookCategory2 = new BookCategory();
		bookCategory2.setName("History");

		bookCategoryRepository.save(bookCategory1);
		bookCategoryRepository.save(bookCategory2);*/
		/*BookCategory bookCategory = new BookCategory("Programming",
				new Book("Belajar Java","Erick Kurniawan","ISBN-77886699"),
				new Book("Belajar Spring Boot","Scott Hanselmen","99887766")
		);
		bookCategoryRepository.save(bookCategory);
		LOG.info("----- Berhasil menyimpan book category");*/

		/*List<Book> books = bookRepository.findAll();

		LOG.info("-----> Book: "+books.get(0).getTitle());
		LOG.info("-----> Book: "+books.get(1).getTitle());

		List<Book> bookByWriter = bookRepository.findAllByWriterContaining("Erick");
		LOG.info("-----> Book by Writer : "+bookByWriter.get(0).getTitle());

		Book myBook = bookRepository.findByIsbn("IS-99887766");
		LOG.info("-----> Book by Isbn : "+myBook.getTitle());

		List<Book> bookByIsbn = bookRepository.findAllByIsbnContaining("8");
		for (Book book:bookByIsbn) {
			LOG.info("-----> Book by ISBN : "+book.getTitle());
		}

		List<Book> nativeQuery = bookRepository.findAllQueryNative();
		for (Book book:bookByIsbn) {
			LOG.info("-----> Book Native : "+book.getTitle());
		}

		List<Book> booksWriteNative = bookRepository.findAllByWriterNative("Erick Kurniawan");
		for (Book book:booksWriteNative) {
			LOG.info("-----> Book Writer Native : "+book.getTitle());
		}*/

		//LOG.info("----- Berhasil menyimpan: "+book1.getTitle());
		//LOG.info("----- Berhasil menyimpan: "+book2.getTitle());


		/*Optional<BookCategory> bookCat = bookCategoryRepository.findById(Long.valueOf(3));
		Optional<Book> editBook = bookRepository.findById(2l);
		if(editBook.isPresent()){
			Book bookEdit = editBook.get();
			bookEdit.setBookCategory(bookCat.get());
			bookRepository.save(bookEdit);
			LOG.info("-----> Edit Book Category Berhasil");
		}
		else {
			LOG.warn("-----> Id Book tidak ditemukan");
		}*/

		List<Book> books = bookRepository.findAll();
		for(Book book : books)
		{
			LOG.info("-----> Book "+book.getTitle()+" - Category: "
					+ book.getBookCategory().getId() +" - "+  book.getBookCategory().getName());
		}

	}
}
