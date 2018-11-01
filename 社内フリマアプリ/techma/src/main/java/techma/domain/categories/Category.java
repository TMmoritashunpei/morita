package techma.domain.categories;

import java.util.List;

import javax.persistence.*;

import lombok.*;
import techma.domain.items.Item;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@OneToMany(cascade = CascadeType.REFRESH ,fetch = FetchType.LAZY, mappedBy = "category")
	private List<Item> item;
}
