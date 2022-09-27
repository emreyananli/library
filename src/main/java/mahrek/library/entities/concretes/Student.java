package mahrek.library.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name="students")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","borrows"})
public class Student {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@Column (name="student_id")
	private int studentId;
	
	@Column (name="student_no")
	private int studentNo;
	
	@Column (name="first_name")
	private String firstName;
	
	@Column (name="last_name")
	private String lastName;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column (name="dateofbirth")
	private Date dateofbirth;
	
	@Column (name="gender")
	private char gender;
	
	//@OneToOne (cascade = CascadeType.REMOVE)
	//@JoinColumn(name = "person_id")
	//private Person person;
	
	@OneToMany(mappedBy = "student")
	private List<Borrow> borrows;
}