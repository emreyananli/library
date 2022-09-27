package mahrek.library.business.abstracts;

import java.sql.Date;
import java.util.List;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.entities.concretes.Borrow;
import mahrek.library.entities.concretes.dtos.BorrowDto;

public interface BorrowService {
	
	DataResult<List<Borrow>> getAll();  
		  
	DataResult<Borrow> add(Borrow borrow);
		  
	DataResult<Borrow> findById(int borrowId);
		  
	DataResult<Borrow> deleteById(int borrowId);
		  
	DataResult<List<Borrow>> findByTakenDate(Date takenDate);
		  
	DataResult<List<Borrow>> findByBroughtDate(Date broughtDate);
		  
	DataResult<List<BorrowDto>> getBorrowWithStudentDetails(); 
		  
	DataResult<List<BorrowDto>> getBorrowWithBookDetails();
	  
	//DataResult<List<BorrowDto>> getAllBorrow(int pageNo, int pageSize);
	  
	//DataResult<List<BorrowDto>> getAllBorrow();  
}