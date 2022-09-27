package mahrek.library.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mahrek.library.business.abstracts.BorrowService;
import mahrek.library.core.utilities.results.DataResult;
import mahrek.library.core.utilities.results.ErrorDataResult;
import mahrek.library.core.utilities.results.SuccessDataResult;
import mahrek.library.dataAccess.abstracts.BorrowDao;
import mahrek.library.entities.concretes.Borrow;
import mahrek.library.entities.concretes.dtos.BorrowDto;

@Service
public class BorrowManager implements BorrowService{
	
	@Autowired
	private BorrowDao borrowDao;
	
	@Override
	public DataResult<List<Borrow>> getAll() {
		
		return new SuccessDataResult<List<Borrow>>(this.borrowDao.findAll(),"veri listelendi");
		
	}

	@Override
	public DataResult<Borrow> add(Borrow borrow) {
		
		return new SuccessDataResult<Borrow>(borrowDao.save(borrow), "Student getirildi.");
	}
	

	@Override
	public DataResult<Borrow> findById(int borrowId) {
		
		if(this.borrowDao.existsById(borrowId)) {
			
			return new SuccessDataResult<Borrow>(borrowDao.findById(borrowId), "Ödünç alma bilgileri getirildi.");
			
		} else {
			
			return new ErrorDataResult<Borrow>("id hatası, gelen id: " + borrowId);
		}	
		
	}
	
	@Override
	public DataResult<Borrow> deleteById(int borrowId) {
		
	if(this.borrowDao.existsById(borrowId)) {
				
			return new SuccessDataResult<Borrow>(this.borrowDao.deleteById(borrowId), "Student silindi");
				
			} else {
				
				return new ErrorDataResult<Borrow>("verilen id'ye sahip bir öğrenci bulunmamakta : " + borrowId);
			}	
			
		}
	
	@Override
	public DataResult<List<Borrow>> findByTakenDate(Date takenDate) {
		
	if(this.borrowDao.existsByTakenDate(takenDate)) {
				
				return new SuccessDataResult<List<Borrow>>(this.borrowDao.findByTakenDate(takenDate), "Bu tarihteki ödünç alma bilgileri: ");
				
			} else {
				
				return new ErrorDataResult<List<Borrow>>("id hatası, gelen id: " + takenDate);
			}
			
		}
	
	@Override
	public DataResult<List<Borrow>> findByBroughtDate(Date broughtDate) {
		
	if(this.borrowDao.existsByBroughtDate(broughtDate)) {
				
				return new SuccessDataResult<List<Borrow>>(borrowDao.findByBroughtDate(broughtDate), "Kitap teslim bilgileri getirildi.");
				
			} else {
				
				return new ErrorDataResult<List<Borrow>>("bu tarihte geri getirilen bir kitap yok : " + broughtDate);
			}
			
		}
	@Override
	public DataResult<List<BorrowDto>> getBorrowWithStudentDetails() {
		
		return new SuccessDataResult<List<BorrowDto>>(this.borrowDao.getBorrowWithStudentDetails(),"Data listelendi");
	}
	
	@Override
	public DataResult<List<BorrowDto>> getBorrowWithBookDetails() {
		
		return new SuccessDataResult<List<BorrowDto>>(this.borrowDao.getBorrowWithBookDetails(),"Data listelendi");
	}
	
	

//	@Override
//	public DataResult<List<BorrowDto>> getAllBorrow() {
//		return new SuccessDataResult<List<BorrowDto>>(this.borrowDao.getAllBorrow(), "Person Listelendi");
//	}

	
}