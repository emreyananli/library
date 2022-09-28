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

import mahrek.library.business.abstracts.PersonService;
import mahrek.library.core.entities.Person;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.ErrorDataResult;
import mahrek.library.core.utilities.results.Result;

@RestController
@RequestMapping("/api/peoples")
public class PersonsController {
		
	@Autowired
	private PersonService personService;
		
	@GetMapping("/getall")
	public DataResult<List<Person>> getall(){
			return this.personService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Person person) {
		return ResponseEntity.ok(this.personService.add(person));
	}
		
	@GetMapping(value = "/findById")
	public DataResult<Person> findById(@RequestParam int personId){
		return this.personService.findById(personId);
	}
		
	@DeleteMapping(value = "/deleteById")
	public ResponseEntity<?> deleteById(@Valid @RequestParam int genreId){
		return ResponseEntity.ok(this.personService.deleteById(genreId));
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