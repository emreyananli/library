package mahrek.library.business.abstracts;

import java.util.List;

import mahrek.library.core.entities.Book;
import mahrek.library.core.entities.dtos.BookAddDto;
import mahrek.library.core.entities.dtos.BookDto;
import mahrek.library.core.entities.dtos.BookGetDto;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.Result;

public interface BookService {

	DataResult<List<BookGetDto>> getAll(); 
	
	Result addBook(BookAddDto bookAddDto);
		  
	DataResult<Book> findById(int bookId);
		  
	DataResult<Book> deleteById(int bookId);
	
	DataResult<Book> updateBook(Book book);
		  
	DataResult<Book> getByBookName(String bookName);
	
	DataResult<List<BookDto>> getBookWithAuthorDetails(); 
		  
	DataResult<List<BookDto>> getBookWithGenreDetails();
}