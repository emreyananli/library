package mahrek.library.core.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthorDto {
	
	private int authorId;
	private String firstName;
	private String lastName;	
	
}
