package mahrek.library.entities.concretes.dtos;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentGetDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private int studentNo;
	private String firstName;
	private String lastName;
	private Date dateofbirth;
	private char gender;
}