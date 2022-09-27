package mahrek.library.core.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDto {
	
	private int bookId;
	private String bookName;
	private int pagecount;
	private int authorId;
	private int genreId;
	private String firstName;
	private String lastName;
	private String genreName;
	
	public BookDto(int bookId, String bookName, int pagecount, int authorId, String firstName, String lastName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.pagecount = pagecount;
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public BookDto(int bookId, String bookName, int pagecount, int genreId, String genreName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.pagecount = pagecount;
		this.genreId = genreId;
		this.genreName = genreName;
	}
}