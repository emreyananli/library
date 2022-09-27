package mahrek.library.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mahrek.library.business.abstracts.GenreService;
import mahrek.library.core.dataAccess.GenreDao;
import mahrek.library.core.entities.Genre;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.ErrorDataResult;
import mahrek.library.core.utilities.results.SuccessDataResult;

@Service
public class GenreManager implements GenreService{
	 
	
	    @Autowired
		private GenreDao genreDao;
		
		@Override
		public DataResult<List<Genre>> getAll() {
			
			return new SuccessDataResult<List<Genre>>(this.genreDao.findAll(),"Türler listelendi");
		}

		@Override
		public DataResult<Genre> add(Genre genre) {
			
			return new SuccessDataResult<Genre>(genreDao.save(genre), "Tür kaydedildi");
		}

		@Override
		public DataResult<Genre> findById(int genreId) {
			
			if(this.genreDao.existsById(genreId)) {
				
				return new SuccessDataResult<Genre>(genreDao.findById(genreId), "Tür getirildi.");
				
				} else {
					
					return new ErrorDataResult<Genre>("id hatası, gelen id: " + genreId);
				}
			}
			
		@Override
		public DataResult<Genre> deleteById(int genreId) {
			
			
			if(this.genreDao.existsById(genreId)) {
				
				return new SuccessDataResult<Genre>(this.genreDao.deleteById(genreId), "Yazar silindi");
				
			} else {
				
				return new ErrorDataResult<Genre>("verilen id'ye sahip bir tür bulunmamakta : " + genreId);
			}		
		}		
}