package mahrek.library.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import mahrek.library.core.entities.Person;

public interface PersonDao extends JpaRepository<Person, Integer>{

	boolean existsById(int personId);
	
	Person findById(int personId);
	
	Person deleteById(int personId);
}
