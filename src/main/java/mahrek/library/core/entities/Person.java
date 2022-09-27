package mahrek.library.core.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="persons")
@AllArgsConstructor
@NoArgsConstructor

public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="person_id")
	private int personId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column (name="gender")
	private char gender;	
	
	//@OneToOne(mappedBy = "person", cascade = CascadeType.REMOVE) 
	//private Student student;
	
	//@OneToOne(mappedBy = "person", cascade = CascadeType.REMOVE) 
	//private Author author;
}