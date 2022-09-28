package mahrek.library.core.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="authors")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","books"})

public class Author {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@Column (name="author_id")
	private int authorId;
	
	@Column (name="first_name")
	private String firstName;
	
	@Column (name="last_name")
	private String lastName;
	
	//@OneToOne (cascade = CascadeType.REMOVE)
	//@JoinColumn(name = "person_id")
	//private Person person;
	
	@OneToMany(mappedBy = "author")
	private List<Book> books;
}						