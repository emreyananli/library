package mahrek.library.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mahrek.library.business.abstracts.AuthorService;
import mahrek.library.core.dataAccess.AuthorDao;
import mahrek.library.core.entities.Author;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.ErrorDataResult;
import mahrek.library.core.utilities.results.SuccessDataResult;

@Service
public class AuthorManager implements AuthorService{

	@Autowired
	private AuthorDao authorDao;
	
	@Override
	public DataResult<List<Author>> getAll() {
		
		return new SuccessDataResult<List<Author>>(this.authorDao.findAll(),"Yazarlar listelendi");
	}
	
	@Override
	public DataResult<Author> add(Author author) {
		
		return new SuccessDataResult<Author>(authorDao.save(author), "Yazar kaydedildi");
	}

	@Override
	public DataResult<Author> findById(int authorId) {
		
		if(this.authorDao.existsById(authorId)) {
			
		return new SuccessDataResult<Author>(authorDao.findById(authorId), "Yazar getirildi.");
		
		} else {
			
			return new ErrorDataResult<Author>("id hatası, gelen id: " + authorId);
		}
	}

	@Override
	public DataResult<Author> deleteById(int authorId) {
		
		if(this.authorDao.existsById(authorId)) {
			
			return new SuccessDataResult<Author>(this.authorDao.deleteById(authorId), "Yazar silindi");
			
		} else {
			
			return new ErrorDataResult<Author>("verilen id'ye sahip bir öğrenci bulunmamakta : " + authorId);
		}	
		
	}	
		@Override
		public DataResult<Author> getByFirstName(String firstName) {
		
			if(this.authorDao.existsByFirstName(firstName)) {
			
				return new SuccessDataResult<Author>(this.authorDao.getByFirstName(firstName),"Yazar listelendi");
			
				} else {
				
					return new ErrorDataResult<Author>("hatalı isim, gelen isim" + firstName);
				}
		
		}
}