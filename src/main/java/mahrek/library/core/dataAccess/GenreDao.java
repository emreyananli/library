package mahrek.library.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import mahrek.library.core.entities.Genre;

public interface GenreDao extends JpaRepository<Genre, Integer>{
	
	boolean existsById(int genreId);
		
	Genre findById(int genreId);
		
	Genre deleteById(int genreId);
}