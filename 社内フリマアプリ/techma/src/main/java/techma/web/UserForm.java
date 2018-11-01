package techma.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserForm {
	//@NotNull
	private Integer id;
	@NotNull
	private String username;
	@NotNull
	@Size(max = 100,message="100文字以内で入力してください。")
	@Pattern(regexp = "^([\\w])+([\\w\\._-])*\\@([\\w])+([\\w\\._-])*\\.([a-zA-Z])+$",message="メールアドレスが不正です。")
	private String mail;
	@NotNull
	@Size(min = 4,max = 15,message="4~15文字で入力してください。")
	@Pattern(regexp = "^[0-9|a-z|A-Z]+$",message="半角英数で入力してください")
	private String password;
	@Size(min = 4,max = 15,message="4~15文字で入力してください。")
	@Pattern(regexp = "^[0-9|a-z|A-Z]+$",message="半角英数で入力してください")
	private String password2;
	//@NotNull
	private boolean login_check = true;
	//@NotNull
	private boolean admin_flg = false;
	//@NotNull
	private Integer employee_id;
	
}
