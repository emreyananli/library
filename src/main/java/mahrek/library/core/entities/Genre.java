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
@Table(name="genres")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","books"})

public class Genre {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@Column (name="genre_id")
	private int genreId;
	
	@Column (name="genre_name")
	private String genreName;
	
	@OneToMany(mappedBy = "genre")
	private List<Book> books;	
}