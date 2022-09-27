package mahrek.library.core.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonDto {
	
	private int personId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private char gender;
}
