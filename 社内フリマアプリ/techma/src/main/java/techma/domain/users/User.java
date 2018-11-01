package techma.domain.users;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import techma.domain.items.Item;

import java.util.List;
@Entity
@Proxy(lazy=false)
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Integer id;
	@Column(name="username", nullable = false)
	private String username;
	@Column(name="mail", nullable = false)
	private String mail;
	@Column(name="password", nullable = false)
	private String password;
	//@Column(nullable = false)
	private boolean login_check;
	//@Column(nullable = false)
	private boolean admin_flg;
	//@Column(nullable = false)
	private Integer employee_id;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Item> item;
}
