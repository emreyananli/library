package mahrek.library.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mahrek.library.entities.concretes.Borrow;
import mahrek.library.entities.concretes.dtos.BorrowDto;

public interface BorrowDao extends JpaRepository<Borrow, Integer> {
		
	boolean existsById(int borrowId);
		
	Borrow findById(int borrowId);
	
	Borrow deleteById(int borrowId);
		
	boolean existsByTakenDate(Date takenDate);
		
	List<Borrow> findByTakenDate(Date takenDate);
		
	boolean existsByBroughtDate(Date broughtDate);
		
	List<Borrow> findByBroughtDate(Date broughtDate);
				
	@Query("Select new mahrek.library.entities.concretes.dtos.BorrowDto"
		+"(b.borrowId, b.takenDate, b.broughtDate,"
		+"s.studentId, s.firstName, s.lastName)"
		+"from Borrow b Inner Join b.student s")
		List<BorrowDto> getBorrowWithStudentDetails();
		
	@Query("Select new mahrek.library.entities.concretes.dtos.BorrowDto"
		+"(b.borrowId, b.takenDate, b.broughtDate,"
		+"bo.bookId, bo.bookName, bo.pagecount)"
		+"from Borrow b Inner Join b.book bo")
		List<BorrowDto> getBorrowWithBookDetails();
		
/*				@Query("Select new mahrek.library.entities.concretes.dtos.BorrowDto"
				+"(b.borrowId, b.takenDate, b.broughtDate,"
				+"s.studentId, s.firstName, s.lastName,"
				+"bo.bookId, bo.bookName, bo.pagecount)"
				+"from Borrow b Inner Join b.student s"
				+"Inner Join b.book bo")
				List<BorrowDto> getAllBorrow();
		
				/*	@Query("Select new mahrek.library.entities.concretes.dtos.BorrowDto"
				+"(b.borrowId, b.takenDate, b.broughtDate,"
				+"s.studentId, s.firstName, s.lastName"
				+"bo.bookId, bo.bookName, bo.pagecount)"
				+"from Borrow b Inner Join b.student s"
				+"Inner Join b.book bo")
				Page<BorrowDto> getAllBorrow(Pageable pageable);		 */	
}