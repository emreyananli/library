package mahrek.library.api.controllers;

import java.sql.Date;
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

import mahrek.library.business.abstracts.BorrowService;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.ErrorDataResult;
import mahrek.library.core.utilities.results.Result;
import mahrek.library.entities.concretes.Borrow;
import mahrek.library.entities.concretes.dtos.BorrowDto;

@RestController
@RequestMapping("/api/borrows")

public class BorrowsController {
		
	@Autowired
	private BorrowService borrowService;
		
	@GetMapping("/getall")
	public DataResult<List<Borrow>> getall(){
		return this.borrowService.getAll();
	}	
		
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Borrow borrow) {
		return ResponseEntity.ok(this.borrowService.add(borrow));
	}
	
	@GetMapping(value = "/findById")
	public DataResult<Borrow> findById(@RequestParam int borrowId){
		return this.borrowService.findById(borrowId);
	}
		
	@DeleteMapping(value = "/deleteById")
	public ResponseEntity<?> deleteById(@Valid @RequestParam int borrowId){
		return ResponseEntity.ok(this.borrowService.deleteById(borrowId));
	}
		
	@GetMapping(value = "/findByTakenDate")
	public DataResult<List<Borrow>> findByTakenDate(@RequestParam Date takenDate){
		return this.borrowService.findByTakenDate(takenDate);
	}
		
	@GetMapping(value = "/findByBroughtDate")
	public DataResult<List<Borrow>> findByBroughtDate(@RequestParam Date broughtDate){
		return this.borrowService.findByBroughtDate(broughtDate);
	}
		
	@GetMapping("/getBorrowWithStudentDetails")
	public DataResult<List<BorrowDto>> getBorrowWithStudentDetails(){
		return this.borrowService.getBorrowWithStudentDetails();
	}
		
	
	@GetMapping("/getBorrowWithBookDetails")
	public DataResult<List<BorrowDto>> getBorrowWithBookDetails(){
		return this.borrowService.getBorrowWithBookDetails();
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
		
//	@GetMapping(value = "/getAllBorrow")
	//	public DataResult<List<BorrowDto>> getAllBorrow(){
//			return borrowService.getAllBorrow();
//	}
}