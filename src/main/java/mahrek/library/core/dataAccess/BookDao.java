package mahrek.library.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import mahrek.library.core.entities.Book;
import mahrek.library.core.entities.dtos.BookDto;


public interface BookDao extends JpaRepository<Book, Integer>{
		
	boolean existsById(int bookId);
		
	Book findById(int bookId);
		
	Book deleteById(int bookId);
		
	boolean existsByBookName(String bookName);
	
	Book getByBookName(String bookName);
	
	@Modifying
    @Query("update Book bo set bo.bookName=?2 where bo.bookId=?1")
    Book updateAddress(int bookId, String bookName);
		
	@Query("Select new mahrek.library.core.entities.dtos.BookDto"
		+"(bo.bookId, bo.bookName, bo.pagecount,"
		+"a.authorId, a.firstName, a.lastName)"
		+"from Book bo Inner Join bo.author a")
		List<BookDto> getBookWithAuthorDetails();
		
	@Query("Select new mahrek.library.core.entities.dtos.BookDto"
		+"(bo.bookId, bo.bookName, bo.pagecount,"
		+"g.genreId, g.genreName)"
		+"from Book bo Inner Join bo.genre g")
		List<BookDto> getBookWithGenreDetails();
}		