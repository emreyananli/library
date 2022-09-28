package mahrek.library.core.entities.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookGetDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String bookName;
	private int pagecount;
}