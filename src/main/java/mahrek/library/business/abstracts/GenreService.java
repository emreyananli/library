package mahrek.library.business.abstracts;

import java.util.List;

import mahrek.library.core.entities.Genre;
import mahrek.library.core.utilities.results.DataResult;

public interface GenreService {
	
	DataResult<List<Genre>> getAll();  
		  
	DataResult<Genre> add(Genre genre);
		  	  
	DataResult<Genre> findById(int genreId);
		  	  
	DataResult<Genre> deleteById(int genreId);
}