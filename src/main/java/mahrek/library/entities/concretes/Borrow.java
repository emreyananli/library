package mahrek.library.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mahrek.library.core.entities.Book;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table (name="borrows")
public class Borrow {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@Column (name="borrow_id")
	private int borrowId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "taken_date")
	private Date takenDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "brought_date")
	private Date broughtDate;
	
	@ManyToOne()
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne()
	@JoinColumn(name = "book_id")
	private Book book;
	
}