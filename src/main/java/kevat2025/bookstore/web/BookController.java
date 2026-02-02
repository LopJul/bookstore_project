package kevat2025.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kevat2025.bookstore.domain.Book;
import kevat2025.bookstore.domain.BookRepository;


@Controller
public class BookController {

  private final BookRepository bookRepository;
	// constructor injection. Can only be one constructor then.
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	} 

  @RequestMapping(value= {"/", "/books"})
    public String getBooks(Model model) {	
        model.addAttribute("books", bookRepository.findAll());
        return "/books";
    }

  @RequestMapping(value = "/addBook")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "/addBook";
    }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:/books";
    } 

  @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	bookRepository.deleteById(bookId);
        return "redirect:/books";
    }

  @RequestMapping(value = "/editBook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model){
    	model.addAttribute("book", bookRepository.findById(bookId).orElseThrow());
        return "editBook";
    }
}
