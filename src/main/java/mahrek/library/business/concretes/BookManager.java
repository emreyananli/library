package mahrek.library.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mahrek.library.business.abstracts.BookService;
import mahrek.library.core.dataAccess.BookDao;
import mahrek.library.core.entities.Book;
import mahrek.library.core.entities.dtos.BookDto;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.ErrorDataResult;
import mahrek.library.core.utilities.results.SuccessDataResult;

@Service
public class BookManager implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public DataResult<List<Book>> getAll() {
		
		return new SuccessDataResult<List<Book>>(this.bookDao.findAll(),"kitaplar listelendi");
	}

	@Override
	public DataResult<Book> add(Book book) {
		
		return new SuccessDataResult<Book>(bookDao.save(book), "kitap eklendi");
	}

	@Override
	public DataResult<Book> findById(int bookId) {
	
	if(this.bookDao.existsById(bookId)) {
				
		return new SuccessDataResult<Book>(bookDao.findById(bookId), "Kitap getirildi.");
				
			} else {
				
				return new ErrorDataResult<Book>("id hatası, gelen id: " + bookId);
			}
			
		}
	
	@Override
	public DataResult<Book> deleteById(int bookId) {
		
	if(this.bookDao.existsById(bookId)) {
				
				return new SuccessDataResult<Book>(this.bookDao.deleteById(bookId), "Öğrenci kaydı silindi");
				
			} else {
				
				return new ErrorDataResult<Book>("verilen id'ye sahip bir öğrenci bulunmamakta : " + bookId);
			}
			
			
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

	