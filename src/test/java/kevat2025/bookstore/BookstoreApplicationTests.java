package kevat2025.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kevat2025.bookstore.web.BookController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Test
	void contextLoads() {
	}

	@Test
	public void bookControllerLoad() throws Exception {
		assertThat(bookController).isNotNull();
	}


}
