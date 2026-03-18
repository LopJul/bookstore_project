package kevat2025.bookstore.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import kevat2025.bookstore.domain.Book;
import kevat2025.bookstore.domain.BookRepository;
import kevat2025.bookstore.domain.CategoryRepository;


@Controller
public class BookController {

  private final BookRepository bookRepository;
  private final CategoryRepository categoryRepository;

  public BookController(BookRepository bookRepository, 
    CategoryRepository categoryRepository) {
    this.bookRepository = bookRepository;
    this.categoryRepository = categoryRepository;
  }

  @RequestMapping(value="/login")
  public String login() {
    return "login";
  }

  @GetMapping({"/", "/booklist"})
    public String getBooks(Model model) {	
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/addBook")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
      model.addAttribute("categories", categoryRepository.findAll());
        return "addBook";
    }

  @PostMapping("/save")
    public String save(@Valid Book book, BindingResult bindingResult, Model model){
      if (bindingResult.hasErrors()){
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryRepository.findAll());

        return "addBook";
      }
      bookRepository.save(book);
        return "redirect:/booklist";
    } 

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	bookRepository.deleteById(bookId);
        return "redirect:/booklist";
    }

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model){
    	model.addAttribute("book", bookRepository.findById(bookId).orElseThrow());
      model.addAttribute("categories", categoryRepository.findAll());
        return "editBook";
    }
}
