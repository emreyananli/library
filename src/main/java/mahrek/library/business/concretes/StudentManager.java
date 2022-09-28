package mahrek.library.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mahrek.library.business.abstracts.StudentService;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.ErrorDataResult;
import mahrek.library.core.utilities.results.Result;
import mahrek.library.core.utilities.results.SuccessDataResult;
import mahrek.library.core.utilities.results.SuccessResult;
import mahrek.library.dataAccess.abstracts.StudentDao;
import mahrek.library.entities.concretes.Student;
import mahrek.library.entities.concretes.dtos.StudentAddDto;
import mahrek.library.entities.concretes.dtos.StudentDto;
import mahrek.library.entities.concretes.dtos.StudentGetDto;

@Service
public class StudentManager implements StudentService{
	
	@Autowired
	
	private StudentDao studentDao;
	
	private StudentGetDto convertEntityToDto(Student student){
        StudentGetDto newStudentGetDto = new StudentGetDto();
        newStudentGetDto.setStudentId(student.getStudentId());
        newStudentGetDto.setStudentNo(student.getStudentNo());
        newStudentGetDto.setFirstName(student.getFirstName());
        newStudentGetDto.setLastName(student.getLastName());
        newStudentGetDto.setDateofbirth(student.getDateofbirth());
        newStudentGetDto.setGender(student.getGender());
    
        return newStudentGetDto;
    }
	
	@Override
    public DataResult<List<StudentGetDto>> getAll() {
        return new SuccessDataResult<List<StudentGetDto>>(studentDao.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList()), "Bilgiler listelendi.");
    }

	@Override
	public Result addStudent(StudentAddDto studentAddDto) {
			
            Student newStudent = new Student();

            newStudent.setStudentNo(studentAddDto.getStudentNo());
            newStudent.setFirstName(studentAddDto.getFirstName());
            newStudent.setLastName(studentAddDto.getLastName());
            newStudent.setDateofbirth(studentAddDto.getDateofbirth());
            newStudent.setGender(studentAddDto.getGender());
            
            studentDao.save(newStudent);
            
            return new SuccessResult("Yeni öğrenci listeye eklendi.");
        
	} 
	
	@Override
	public DataResult<Student> findById(int studentId) {
		
		if(this.studentDao.existsById(studentId)) {
			
			return new SuccessDataResult<Student>(this.studentDao.findById(studentId), "Student getirildi.");
			
		} else {
			
			return new ErrorDataResult<Student>("id hatası, gelen id: " + studentId);
		}	
	}
	
	@Override
	public DataResult<Student> deleteById(int studentId) {
		
		if(this.studentDao.existsById(studentId)) {
			
			return new SuccessDataResult<Student>(this.studentDao.deleteById(studentId), "Öğrenci kaydı silindi");
			
		} else {
			
			return new ErrorDataResult<Student>("verilen id'ye sahip bir öğrenci bulunmamakta : " + studentId);
		}		
	}
	
	@Override
	public DataResult<Student> findByStudentNo(int studentNo) {
		
		if(this.studentDao.existsByStudentNo(studentNo)) {
			
			return new SuccessDataResult<Student>(this.studentDao.findByStudentNo(studentNo), "Student getirildi.");
			
		} else {
			
			return new ErrorDataResult<Student>("öğrenci numarası hatası, gelen numara: " + studentNo);
		}
	}
	
	@Override
	public DataResult<List<Student>> getByFirstName(String firstName) {
		
		if(this.studentDao.existsByFirstName(firstName)) {
			
		return new SuccessDataResult<List<Student>>(this.studentDao.getByFirstName(firstName),"Öğrenci listelendi");
		
		} else {
			
			return new ErrorDataResult<List<Student>>("hatalı isim, gelen isim" + firstName);
		}
	}

	@Override
	public DataResult<List<Student>> getByFirstNameContains(String firstName) {
		
		if(this.studentDao.existsByFirstNameContains(firstName)) {
			
			return new SuccessDataResult<List<Student>>(this.studentDao.getByFirstNameContains(firstName),"verilen kısmı iceren ogrenciler listelendi");
			
			} else {
				
				return new ErrorDataResult<List<Student>>("verilen kısmı içeren bir öğrenci ismi yok. verdiğiniz dizi: " + firstName);
			}
		
	}

	@Override
	public DataResult<List<Student>> getByFirstNameStartsWith(String firstName) {
		
		if(this.studentDao.existsByFirstNameStartsWith(firstName)) {
			
			return new SuccessDataResult<List<Student>>(this.studentDao.getByFirstNameStartsWith(firstName),"verilen kısım ile başlayan öğrenciler listelendi");
			
			} else {
				
				return new ErrorDataResult<List<Student>>("verilen kısım ile başlayan bir öğrenci ismi yok. verdiğiniz dizi: " + firstName);
			}
		
	}
	
	@Override
	public DataResult<List<StudentDto>> getStudentWithBorrowDetails() {
		
		return new SuccessDataResult<List<StudentDto>>(this.studentDao.getStudentWithBorrowDetails(),"Öğrencinin ödünç alma bilgileri listelendi");
				
	}
}