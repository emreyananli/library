package mahrek.library.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import mahrek.library.core.entities.Author;

public interface AuthorDao extends JpaRepository<Author, Integer>{
	
	boolean existsById(int authorId);
		
	Author findById(int authorId);
		
	Author deleteById(int authorId);
	
	boolean existsByFirstName(String firstName);
		
	Author getByFirstName(String firstName);
}