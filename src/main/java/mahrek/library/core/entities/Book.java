package mahrek.library.core.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mahrek.library.entities.concretes.Borrow;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")

public class Book {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@Column(name="book_id")
	private int bookId;
	
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="pagecount")
	private int pagecount;
	
	@ManyToOne()
	@JoinColumn(name = "author_id")
	private Author author;
	
	@ManyToOne()
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	@OneToMany(mappedBy = "book")
	private List<Borrow> borrows;
}