package mahrek.library.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import mahrek.library.business.abstracts.BookService;
import mahrek.library.core.dataAccess.BookDao;
import mahrek.library.core.entities.Book;
import mahrek.library.core.entities.dtos.BookAddDto;
import mahrek.library.core.entities.dtos.BookDto;
import mahrek.library.core.entities.dtos.BookGetDto;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.ErrorDataResult;
import mahrek.library.core.utilities.results.Result;
import mahrek.library.core.utilities.results.SuccessDataResult;
import mahrek.library.core.utilities.results.SuccessResult;

@Service
public class BookManager implements BookService{

	@Autowired
	private BookDao bookDao;
	
	private BookGetDto convertEntityToDto(Book book){
        BookGetDto newBookGetDto = new BookGetDto();
        newBookGetDto.setBookId(book.getBookId());
        newBookGetDto.setBookName(book.getBookName());
        newBookGetDto.setPagecount(book.getPagecount());
   
        return newBookGetDto;
    }
	
	@Override
    public DataResult<List<BookGetDto>> getAll() {
        return new SuccessDataResult<List<BookGetDto>>(bookDao.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList()), "Kitaplar listelendi.");
    }

	@Override
	public Result addBook(BookAddDto bookAddDto) {
			
            Book newBook = new Book();

            newBook.setBookName(bookAddDto.getBookName());
            newBook.setPagecount(bookAddDto.getPagecount());
            
            bookDao.save(newBook);
            
            return new SuccessResult("Yeni kitap listeye eklendi.");
        
	}

	@Override
    @Cacheable(cacheNames = "books", key="#book.bookId")
	public DataResult<Book> findById(int bookId) {
	
	if(this.bookDao.existsById(bookId)) {
				
		return new SuccessDataResult<Book>(bookDao.findById(bookId), "Kitap getirildi.");
				
			} else {
				
				return new ErrorDataResult<Book>("id hatası, gelen id: " + bookId);
			}
			
		}
	
	@Override
    @CacheEvict(cacheNames = "books", key = "#book.bookId")
	public DataResult<Book> deleteById(int bookId) {
		
	if(this.bookDao.existsById(bookId)) {
				
				return new SuccessDataResult<Book>(this.bookDao.deleteById(bookId), "Öğrenci kaydı silindi");
				
			} else {
				
				return new ErrorDataResult<Book>("verilen id'ye sahip bir öğrenci bulunmamakta : " + bookId);
			}
			
			
	}
	
	@Override
    @CachePut(cacheNames = "books", key="#book.bookId")
    public DataResult<Book> updateBook(Book book) {
        
        return new SuccessDataResult<Book>(this.bookDao.updateAddress(book.getBookId(), book.getBookName()), "Kitap update edildi");
    }
	
	@Override
	public DataResult<Book> getByBookName(String bookName) {
		
		if(this.bookDao.existsByBookName(bookName)) {
			
			return new SuccessDataResult<Book>(this.bookDao.getByBookName(bookName),"Kitap listelendi");
			
		} else {
				
				return new ErrorDataResult<Book>("hatalı isim, gelen isim" + bookName);
			}
		
	}

	@Override
	public DataResult<List<BookDto>> getBookWithAuthorDetails() {
		
		return new SuccessDataResult<List<BookDto>>(this.bookDao.getBookWithAuthorDetails(),"Data listelendi");
	}

	@Override
	public DataResult<List<BookDto>> getBookWithGenreDetails() {
		
		return new SuccessDataResult<List<BookDto>>(this.bookDao.getBookWithGenreDetails(),"Data listelendi");
	}
}