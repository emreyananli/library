package mahrek.library.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAddDto {
	
	private int studentNo;
	private String firstName;
	private String lastName;
	private Date dateofbirth;
	private char gender;
}