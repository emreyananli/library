package mahrek.library.business.abstracts;

import java.util.List;

import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.entities.Author;

public interface AuthorService {

	DataResult<List<Author>> getAll();  
	  
	DataResult<Author> add(Author author);
	  	  
	DataResult<Author> findById(int authorId);
	  	  
	DataResult<Author> deleteById(int authorId);
	
	DataResult<Author> getByFirstName(String firstName);
}