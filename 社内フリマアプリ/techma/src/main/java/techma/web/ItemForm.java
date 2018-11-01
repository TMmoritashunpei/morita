package techma.web;




import java.sql.Date;

//mport javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import techma.domain.categories.Category;


@Data
public class ItemForm {
	//@NotNull(message="商品名を入力してください")
	//@NotBlank(message="空のテキストボックスがあります")
	//@Size(min = 1,max = 30,message="商品名は30文字数以内で入力して下さい。")
	//@Pattern(regexp = "[^!\\\"#$%&'()\\\\*\\\\+\\\\-\\\\.,\\\\/:;<=>?@\\\\[\\\\\\\\\\\\]^_`{|}~]*",message="商品名は全角かな・半角英数字で入力して下さい。")
	private String name;
	
	//@NotNull(message="メイン画像をアップして下さい。")
	//@Size(min = 1,message="メイン画像をアップして下さい。")
	private MultipartFile file;
	private String picture_main;
    private String picture_sub1;
    private String picture_sub2;
    private String picture_sub3;
    private boolean display_flg = true;
    @NotNull(message="カテゴリを選択してください。")
    private Category category;
    //@NotBlank(message="希望支払い方法を選択してください")
    private String payment;
    @NotNull(message="状態を選択してください")
    private String item_condition;
    @NotNull
    //@NotBlank(message="価格を入力してください。")
    //@Size(max = 6,message="価格は6文字以内で入力してください、")
    //@Pattern(regexp = "[^0-9(\\s|　)]*",message="価格は半角数字で入力して下さい。")
    private int price;
    //@NotBlank(message="商品説明を入力してください。")
    //@Size(min = 1, max = 200,message="商品説明は200文字数以内で入力してください。")
    //@Pattern(regexp = "[^\\\"#$%&'()\\\\*\\\\+\\\\-\\\\.,\\\\/:;<=>@\\\\[\\\\\\\\\\\\]^_`{|}~(\\s|　)]*",message="商品説明は全角かな・半角英数字で入力して下さい。")
    private String comments;
    //@NotNull
    //private String purchase_status;
    private Date date;
    public MultipartFile getFile() {
        return file;
      }

      public void setFile(MultipartFile file) {
        this.file = file;
      }
      public String getPicture(){
          return this.picture_main;
      }
      public void setName(String picture_main){
          this.picture_main = picture_main;
  }
}
