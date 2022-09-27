package mahrek.library.business.abstracts;

import java.util.List;

import mahrek.library.core.entities.Person;
import mahrek.library.core.utilities.results.DataResult;
public interface PersonService {

	DataResult<List<Person>> getAll();
	
	DataResult<Person> findById(int personId);
	
	DataResult<Person> deleteById(int personId);
	
	DataResult<Person> add(Person person);

}
