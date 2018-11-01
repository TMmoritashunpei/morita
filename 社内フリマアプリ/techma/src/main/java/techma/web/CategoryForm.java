package techma.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class CategoryForm {
	@NotNull
	@NotBlank(message="空のテキストボックスがあります")
	@Size(max = 20,message="カテゴリーは20文字数以内で入力して下さい。")
	@Pattern(regexp = "[^\\x01-\\x7E(\\s|　)]*",message="全角文字で入力してください")
	private String name;
}
