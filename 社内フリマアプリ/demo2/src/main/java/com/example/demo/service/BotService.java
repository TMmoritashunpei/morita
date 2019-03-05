package com.example.demo.service;

import java.io.IOException;

import javax.transaction.Transactional;
import org.riversun.slacklet.SlackletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.example.demo.Settings;
import com.example.demo.domain.Item;
import com.example.demo.web.ItemForm;
import com.example.demo.web.UserForm;

@Service
@Transactional
public class BotService {
	@Autowired
    private Settings settings;
	
	public String getKey() {
		return settings.getSlackbotAccessKey();
	}
	
	public void ExhibitBot(ItemForm form, @AuthenticationPrincipal LoginUserDetails userDatails) throws IOException {
		//slackのAPI送信
		String botToken = getKey(); 

		SlackletService slackService = new SlackletService(botToken);
		slackService.start();

		//slackダイレクトメッセージを送る
		String userName = userDatails.getUser().getSlackname();
		slackService.sendDirectMessageTo(userName, userName+"さん！商品の出品が完了しました。出品履歴画面で商品の確認が可能です。  商品名:  "
		+form.getItemname()+"  数量:  "+ form.getStock()+"点"+"  カテゴリー:   "+form.getCategory().getCategoryname() + "  techmaのtopはこちら http://localhost:8080/techmatop/techma/" );

		// slackとの接続を終了
		slackService.stop();
	}
	
	public void UsercreateBot(UserForm form) throws IOException {
		//slackのAPI送信
		String botToken = getKey();

		SlackletService slackService = new SlackletService(botToken);
		slackService.start();

		//slackダイレクトメッセージを送る
		String userName = form.getSlackname();
		slackService.sendDirectMessageTo(userName, userName+"さんのアカウント作成が完了しました。ログインしてtechmaをお楽しみください。 techmaのtopはこちら http://localhost:8080/techmatop/techma/");

		// slackとの接続を終了
		slackService.stop();
	}
	public void purchaseBot(Item item, ItemForm form, @AuthenticationPrincipal LoginUserDetails userDatails) throws IOException {
		//slackのAPI送信
		String botToken = getKey();

		SlackletService slackService = new SlackletService(botToken);
		slackService.start();

		//slackダイレクトメッセージを送る
		String purchaseName = userDatails.getUser().getSlackname();
		slackService.sendDirectMessageTo(purchaseName, purchaseName+"さん！商品の購入が完了致しました。購入履歴画面で商品の確認が可能です。  商品名:"
		+ item.getItemname() + "  購入数:  " + form.getPurchasenumber() + "  出品者  " + item.getUser().getUsername()+"  techmaのtopはこちら http://localhost:8080/techmatop/techma/");

				
	}
	public void ExhibitPurchaseBot(Item item, ItemForm form, @AuthenticationPrincipal LoginUserDetails userDatails) throws IOException {
		String botToken = getKey(); 

		SlackletService slackService = new SlackletService(botToken);
		slackService.start();
		
		//slackダイレクトメッセージを送る
		String exhibitName = item.getUser().getSlackname();
		slackService.sendDirectMessageTo(exhibitName, exhibitName+"さん！出品した商品の購入申し込みが行われました。出品履歴画面で商品の確認が可能です。  商品名:"
		+ item.getItemname() + "  購入数:  " + form.getPurchasenumber() + "  購入者  " + userDatails.getUser().getUsername());

		// slackとの接続を終了
		slackService.stop();
	}
}
