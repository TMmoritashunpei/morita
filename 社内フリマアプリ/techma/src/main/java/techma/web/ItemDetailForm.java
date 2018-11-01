package techma.web;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import techma.domain.categories.Category;
import techma.domain.users.User;

@Data
public class ItemDetailForm {
	@Column(updatable=false)
    private Integer id;
	@Column(updatable=false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @Column(updatable=false)
    private User user;
    @Column(updatable=false)
    private String picture_main;
    @Column(updatable=false)
    private String picture_sub1;
    @Column(updatable=false)
    private String picture_sub2;
    @Column(updatable=false)
    private String picture_sub3;
    @Column(updatable=true)
    private boolean display_flg;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    @Column(updatable=false)
    private Category category;
    @Column(updatable=false)
    private String payment;
    @Column(updatable=false)
    private String item_condition;
    @Column(updatable=false)
    private int price;
    @Column(updatable=false)
    private String comments;
//    @NotNull
//    private String purchase_status;
//    @Column(updatable=false)
//    private Date date;
}
