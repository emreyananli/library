package mahrek.library.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mahrek.library.business.abstracts.BookService;
import mahrek.library.core.entities.Book;
import mahrek.library.core.entities.dtos.BookDto;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.ErrorDataResult;
import mahrek.library.core.utilities.results.Result;

@RestController
@RequestMapping("/api/books")

public class BooksController {
		
	@Autowired
	private BookService bookService;
		
	@GetMapping("/getall")
	public DataResult<List<Book>> getall(){
		return this.bookService.getAll();
	}
		
		
	@PostMapping("/add")
	public Result add(@RequestBody Book book) {
		return this.bookService.add(book);
	}
	
		
	@GetMapping(value = "/findById")
	public ResponseEntity<?> findById(@RequestParam int bookId){
		return ResponseEntity.ok(this.bookService.findById(bookId));
	}
	
	@DeleteMapping(value = "/deleteById")
	public ResponseEntity<?> deleteById(@Valid @RequestParam int bookId){
		return ResponseEntity.ok(this.bookService.deleteById(bookId));
	}
	
	@GetMapping("/getByBookName")
	public DataResult<Book> getByBookName(@RequestParam String bookName){
		return this.bookService.getByBookName(bookName);
	}
	
	@GetMapping("/getBookWithAuthorDetails")
	public DataResult<List<BookDto>> getBookWithAuthorDetails(){
		return this.bookService.getBookWithAuthorDetails();
	}
	
	
	@GetMapping("/getBookWithGenreDetails")
	public DataResult<List<BookDto>> getBookWithGenreDetails(){
		return this.bookService.getBookWithGenreDetails();
	}
			
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
			
		Map<String, String> validationErrors = new HashMap<String, String>();

	    for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
	    	validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	}

	    ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
	    return errors;
	}
}