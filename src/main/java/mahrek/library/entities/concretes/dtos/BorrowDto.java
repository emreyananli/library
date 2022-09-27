package mahrek.library.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowDto {
	
	private int borrowId;
	private Date takenDate;
	private Date broughtDate;
	private int studentId;
	private String firstName;
	private String lastName;
	private int bookId;
	private String bookName;
	private int pagecount;
	
	public BorrowDto(int borrowId, Date takenDate, Date broughtDate, int studentId, String firstName, String lastName) {
		super();
		this.borrowId = borrowId;
		this.takenDate = takenDate;
		this.broughtDate = broughtDate;
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public BorrowDto(int borrowId, Date takenDate, Date broughtDate, int bookId, String bookName, int pagecount) {
		super();
		this.borrowId = borrowId;
		this.takenDate = takenDate;
		this.broughtDate = broughtDate;
		this.bookId = bookId;
		this.bookName = bookName;
		this.pagecount = pagecount;
	}
}