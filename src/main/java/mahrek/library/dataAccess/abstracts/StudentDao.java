package mahrek.library.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mahrek.library.entities.concretes.Student;
import mahrek.library.entities.concretes.dtos.StudentDto;


public interface StudentDao extends JpaRepository<Student,Integer>{
		
	boolean existsById(int studentId);
		
	Student findById(int studentId);
		
	Student deleteById(int studentId);
		
	boolean existsByStudentNo(int studentNo);
		
	Student findByStudentNo(int studentNo);
		
	boolean existsByFirstName(String firstName);
		
	List<Student> getByFirstName(String firstName);
		
	boolean existsByFirstNameContains(String firstName);
		
	List<Student> getByFirstNameContains(String firstName);
		
	boolean existsByFirstNameStartsWith(String firstName);

	List<Student> getByFirstNameStartsWith(String firstName); 
		
	@Query("Select new mahrek.library.entities.concretes.dtos.StudentDto"
		+"(s.studentId, s.firstName, s.lastName,"
		+"b.takenDate, b.broughtDate)"
		+"from Borrow b Inner Join b.student s")
		List<StudentDto> getStudentWithBorrowDetails();
		
		
/*		@Query("Select new mahrek.library.entities.concretes.dtos.StudentDto"
		+"(s.studentId, s.studentNo,"
		+"p.personId, p.firstName, p.lastName, p.dateOfBirth, p.gender)"
		+"from Student s Inner Join s.person p")
		List<StudentDto> findStudentWithPersonDetails(); 
		
		
		@Query("Select new mahrek.library.entities.concretes.dtos.StudentDto"
		+"(s.studentId, s.studentNo,"
		+"p.personId, p.firstName, p.lastName, p.dateOfBirth, p.gender,"
		+"b.takenDate, b.broughtDate)"
		+"from Student s Inner Join s.person p"
		+"Inner Join s.borrow b")
		List<StudentDto> findAllStudent();
		
		@Query("Select new mahrek.library.entities.concretes.dtos.StudentDto"
		+"(s.studentId, s.studentNo,"
		+"p.personId, p.firstName, p.lastName, p.dateOfBirth, p.gender,"
		+"b.takenDate, b.broughtDate)"
		+"from Student s Inner Join s.person p"
		+"Inner Join s.borrow b")
		Page<StudentDto> findAllStudent(Pageable pageable);		*/
}