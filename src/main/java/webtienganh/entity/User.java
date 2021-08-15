package webtienganh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private String username;
	private String password;
	private String token;

	@Enumerated(EnumType.STRING)
	private Provider provider;
	private String providerId;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<UserRole> roles = new ArrayList<>();

	public User(String name, String username, String password, String token, List<UserRole> roles) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.token = token;
		this.roles = roles;
	}

}
