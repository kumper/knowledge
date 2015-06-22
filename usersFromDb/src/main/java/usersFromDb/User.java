package usersFromDb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String supplierCode;
	private String roles;
	
	public User() {}

	public User(String username, String firstName, String lastName,
			String password, String supplierCode, String roles) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.supplierCode = supplierCode;
		this.roles = roles;
	}

	public User(User user) {
		this(user.getUsername(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getSupplierCode(), user.getRoles());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return String
				.format("User [id=%s, username=%s, firstName=%s, lastName=%s, password=%s, supplierCode=%s, roles=%s]",
						id, username, firstName, lastName, password,
						supplierCode, roles);
	}

}
