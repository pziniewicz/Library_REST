package pl.coderslab;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Book> getList() {
        return mockBookService.getList();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        mockBookService.addNewBook(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return mockBookService.getBook(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        mockBookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public void editBook(@PathVariable Long id, @RequestBody Book book) {
        mockBookService.editBook(id, book);
    }

}