package mahrek.library.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.http.HttpStatus;

import mahrek.library.business.abstracts.StudentService;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.ErrorDataResult;
import mahrek.library.core.utilities.results.Result;
import mahrek.library.entities.concretes.Student;
import mahrek.library.entities.concretes.dtos.StudentAddDto;
import mahrek.library.entities.concretes.dtos.StudentDto;
import mahrek.library.entities.concretes.dtos.StudentGetDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/students")

public class StudentsController {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/getall")
	public DataResult<List<StudentGetDto>> getall(){
		return this.studentService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody StudentAddDto studentAddDto) {
		return ResponseEntity.ok(this.studentService.addStudent(studentAddDto));
	}
	
	@GetMapping(value = "/findById")
	public DataResult<Student> findById(@RequestParam int studentId){
		return this.studentService.findById(studentId);
	}
	
	@DeleteMapping(value = "/deleteById")
	public ResponseEntity<?> deleteById(@Valid @RequestParam int studentId){
		return ResponseEntity.ok(this.studentService.deleteById(studentId));
	}
	
	@GetMapping(value = "/findByNo")
	public DataResult<Student> findByStudentNo(@RequestParam int studentNo){
		return this.studentService.findByStudentNo(studentNo);
	}
	
	@GetMapping("/getByStudentName")
	public DataResult<List<Student>> getByFirstName(@RequestParam String firstName){
		return this.studentService.getByFirstName(firstName);
	}
	
	@GetMapping("/getByStudentNameContains")
	public DataResult<List<Student>> getByFirstNameContains(@RequestParam String firstName){
		return this.studentService.getByFirstNameContains(firstName);
	} 
	
	@GetMapping("/getByStudentNameStartsWith")
	public DataResult<List<Student>> getByStudentNameStartsWith(@RequestParam String firstName){
		return this.studentService.getByFirstNameStartsWith(firstName);
	}
	
	@GetMapping("/getStudentWithBorrowDetails")
	public DataResult<List<StudentDto>> getStudentWithBorrowDetails(){
		return this.studentService.getStudentWithBorrowDetails();
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