package mahrek.library.business.abstracts;

import java.util.List;

import mahrek.library.core.entities.Book;
import mahrek.library.core.entities.dtos.BookDto;
import mahrek.library.core.utilities.results.DataResult;

public interface BookService {

	DataResult<List<Book>> getAll();  
		  
	DataResult<Book> add(Book book);
		  
	DataResult<Book> findById(int bookId);
		  
	DataResult<Book> deleteById(int bookId);
		  
	DataResult<Book> getByBookName(String bookName);
	
	DataResult<List<BookDto>> getBookWithAuthorDetails(); 
		  
	DataResult<List<BookDto>> getBookWithGenreDetails();
}