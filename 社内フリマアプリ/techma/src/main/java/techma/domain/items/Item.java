package techma.domain.items;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import techma.domain.categories.Category;
import techma.domain.users.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable=false)
    private Integer id;
    //@Column(nullable = false, updatable=false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", updatable=false)
    private User user;
    @Column(nullable = false, updatable=false)
    private String picture_main;
    //@Column(updatable=false)
    private String picture_sub1;
    //@Column(updatable=false)
    private String picture_sub2;
    //@Column(updatable=false)
    private String picture_sub3;
    //@Column(nullable = false, updatable=true)
    private boolean display_flg;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", updatable=false)
    private Category category;
    //@Column(updatable=false)
    private String payment;
    //@Column(updatable=false)
    private String item_condition;
    //@Column(nullable = false, updatable=false)
    private int price;
    //@Column(updatable=false)
    private String comments;
    //「表示/非表示」の切り替えには、display_flagで行うため
    //private String purchase_status;
    //@Column(nullable = false, updatable=false)
    private Date date;
}
