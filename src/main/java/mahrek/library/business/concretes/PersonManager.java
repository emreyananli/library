package mahrek.library.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mahrek.library.business.abstracts.PersonService;
import mahrek.library.core.dataAccess.PersonDao;
import mahrek.library.core.entities.Person;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.ErrorDataResult;
import mahrek.library.core.utilities.results.SuccessDataResult;

@Service
public class PersonManager implements PersonService{
	
	@Autowired
	private PersonDao personDao;

	@Override
	public DataResult<List<Person>> getAll() {

		return new SuccessDataResult<List<Person>>(this.personDao.findAll(),"veriler listelendi");
	}
	
	@Override
	public DataResult<Person> add(Person person) {
		
		return new SuccessDataResult<Person>(this.personDao.save(person), "Kişi getirildi.");
	}

	@Override
	public DataResult<Person> findById(int personId) {
		
		if(this.personDao.existsById(personId)) {
			
			return new SuccessDataResult<Person>(this.personDao.findById(personId), "Kişi getirildi.");
			
		} else {
			
			return new ErrorDataResult<Person>("id hatası, gelen id: " + personId);
		}	
}
	
	@Override
	public DataResult<Person> deleteById(int personId) {
		
	if(this.personDao.existsById(personId)) {
				
				return new SuccessDataResult<Person>(this.personDao.deleteById(personId), "Kişi kaydı silindi");
				
			} else {
				
				return new ErrorDataResult<Person>("verilen id'ye sahip bir öğrenci bulunmamakta : " + personId);
			}		
		
		}
}