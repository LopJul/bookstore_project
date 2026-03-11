package kevat2025.bookstore;

import java.util.List;
//import javax.sql.DataSource;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import kevat2025.bookstore.domain.Book;
import kevat2025.bookstore.domain.BookRepository;
import kevat2025.bookstore.domain.Category;
import kevat2025.bookstore.domain.CategoryRepository;

@DataJpaTest
@ActiveProfiles("test")
public class BookRepositoryTests {

@Autowired
private BookRepository bookRepository;

@Autowired
private CategoryRepository categoryRepository;

@Test
public void findByTitleShouldReturnBook() {
  List<Book> books = bookRepository.findByTitle("Puutarha");
  assertThat(books).hasSize(1);
  assertThat(books.get(0).getAuthor()).isEqualTo("Minni Hiiri");
}
@Test
public void createNewBook() {
  Category category = new Category("Sarjis");
  categoryRepository.save(category);
  Book book = new Book("Mikki Hiiri", "Minni Hiiri", 2026, "1232-1", 20.90, category);
  bookRepository.save(book);
  assertThat(book.getId()).isNotNull();
}
@Test
public void deleteBook() {
  List<Book> books = bookRepository.findByAuthor("Minni Hiiri");
  Book book = books.get(0);
  bookRepository.delete(book);
  List<Book> newBooks = bookRepository.findByAuthor("Minni Hiiri");
  assertThat(newBooks).hasSize(0);
}
}
