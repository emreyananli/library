package mahrek.library.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	
	private int studentId;
	private int studentNo;
	private String firstName;
	private String lastName;
	private Date dateofbirth;
	private char gender;
	private Date takenDate;
	private Date broughtDate;
	
	public StudentDto(int studentId, String firstName, String lastName, Date takenDate, Date broughtDate) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.takenDate = takenDate;
		this.broughtDate = broughtDate;
	}
}