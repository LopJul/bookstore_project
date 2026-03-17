package kevat2025.bookstore;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kevat2025.bookstore.domain.AppUser;
import kevat2025.bookstore.domain.AppUserRepository;
import kevat2025.bookstore.domain.Book;
import kevat2025.bookstore.domain.BookRepository;
import kevat2025.bookstore.domain.Category;
import kevat2025.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
	SpringApplication.run(BookstoreApplication.class, args);
	}

@Bean 
public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, AppUserRepository appUserRepository) {
		return (args) -> {
 			log.info("save a couple of books");


 			Category category1 = new Category("Fantasia");
 			Category category2 = new Category("Romaani");
 			Category category3 = new Category("Elämänkerta");

 			categoryRepository.save(category1);
 			categoryRepository.save(category2);
 			categoryRepository.save(category3);

 			bookRepository.save(new Book("Seitsemän sisarta","Lucinda Riley", 2014, "1234-1", 13.90, category1));
 			bookRepository.save(new Book("Vaarallinen kirje","Lucinda Riley", 2021, "1234-2", 15.90, category2));
			
 			//Check if there is already user data in the database
			if (appUserRepository.count() == 0) {
 			log.info("Create some users");
 			AppUser user1 = new AppUser("user", "$2a$10$xsSglTlHmiXBxLBh8lmR2uSIxj/B05AcHKcmWyNHkTZYs/.fEMiG6", "USER");
 			AppUser user2 = new AppUser("admin", "$2a$10$kgsnf8QVsZmNe0jFm0mwmOc.EkZnq6yELdecrgC8Fw7Tz2gCcVrei", "ADMIN");
 			appUserRepository.save(user1);
 			appUserRepository.save(user2);
			}

			log.info("fetch all books");
 			for (Book kirja : bookRepository.findAll()) {
 				log.info(kirja.toString());
 			}

 		};

 }
}
