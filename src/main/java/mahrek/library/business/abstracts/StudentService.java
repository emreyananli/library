package mahrek.library.business.abstracts;
import java.util.List;

import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.Result;
import mahrek.library.entities.concretes.Student;
import mahrek.library.entities.concretes.dtos.StudentAddDto;
import mahrek.library.entities.concretes.dtos.StudentDto;
import mahrek.library.entities.concretes.dtos.StudentGetDto;

public interface StudentService {
	
	DataResult<List<StudentGetDto>> getAll(); 
	
	Result addStudent(StudentAddDto studentAddDto);
	
	DataResult<Student> findById(int studentId);
	
	DataResult<Student> deleteById(int studentId);
	
	DataResult<Student> findByStudentNo(int studentNo);
	 
	DataResult<List<Student>> getByFirstName(String firstName);
	  
	DataResult<List<Student>> getByFirstNameContains(String firstName);
	  
	DataResult<List<Student>> getByFirstNameStartsWith(String firstName);
	  
	DataResult<List<StudentDto>> getStudentWithBorrowDetails();
}