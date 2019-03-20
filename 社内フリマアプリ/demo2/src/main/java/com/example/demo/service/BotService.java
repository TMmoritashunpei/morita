package com.example.demo.service;

import java.io.IOException;

import javax.transaction.Transactional;
import org.riversun.slacklet.SlackletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.example.demo.Settings;
import com.example.demo.domain.Item;
import com.example.demo.domain.Purchase;
import com.example.demo.domain.User;
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
		//String botToken = getKey(); 
		//環境変数使用
		String botToken = System.getenv("botkey");

		SlackletService slackService = new SlackletService(botToken);
		slackService.start();

		//slackダイレクトメッセージを送る
		String userName = userDatails.getUser().getSlackname();
		slackService.sendDirectMessageTo(userName, userName+"さん！商品の出品が完了しました。出品履歴画面で商品の確認が可能です。  商品名:  "
		+form.getItemname() + "  数量:  " +  form.getStock()+"点" + "  カテゴリー:   " + form.getCategory().getCategoryname() 
		+ "  techmaのtopはこちら https://techmah2.herokuapp.com/techmatop/" );

		// slackとの接続を終了
		slackService.stop();
	}
	
	public void UsercreateBot(UserForm form) throws IOException {
		//slackのAPI送信
		//String botToken = getKey();
		//環境変数使用
		String botToken = System.getenv("botkey");

		SlackletService slackService = new SlackletService(botToken);
		slackService.start();

		//slackダイレクトメッセージを送る
		String userName = form.getSlackname();
		slackService.sendDirectMessageTo(userName, userName+"さんのアカウント作成が完了しました。ログインしてtechmaをお楽しみください。 "
		+ "techmaのtopはこちら https://techmah2.herokuapp.com/techmatop");

		// slackとの接続を終了
		slackService.stop();
	}
	public void purchaseBot(Item item, ItemForm form, @AuthenticationPrincipal LoginUserDetails userDatails) throws IOException {
		//slackのAPI送信
		//String botToken = getKey();
		//環境変数使用
		String botToken = System.getenv("botkey");

		SlackletService slackService = new SlackletService(botToken);
		slackService.start();

		//slackダイレクトメッセージを送る
		String purchaseName = userDatails.getUser().getSlackname();
		slackService.sendDirectMessageTo(purchaseName, purchaseName+"さん！商品の購入が完了致しました。購入履歴画面で商品の確認が可能です。  商品名:"
		+ item.getItemname() + "  購入数:  " + form.getPurchasenumber() + "  出品者  " + item.getUser().getUsername() 
		+ "  techmaのマイページはこちら https://techmah2.herokuapp.com/techmatop/techma/user");

				
	}
	public void ExhibitPurchaseBot(Item item, ItemForm form, @AuthenticationPrincipal LoginUserDetails userDatails) throws IOException {
		//slackのAPI送信
		//String botToken = getKey();
		//環境変数使用
		String botToken = System.getenv("botkey");
		
		SlackletService slackService = new SlackletService(botToken);
		slackService.start();
		
		//slackダイレクトメッセージを送る
		String exhibitName = item.getUser().getSlackname();
		slackService.sendDirectMessageTo(exhibitName, exhibitName+"さん！出品した商品の購入申し込みが行われました。出品履歴画面で商品の確認が可能です。  商品名:"
		+ item.getItemname() + "  購入数:  " + form.getPurchasenumber() + "  購入者  " + userDatails.getUser().getUsername() 
		+ "  techmaのマイページはこちら https://techmah2.herokuapp.com/techmatop/techma/user");

		// slackとの接続を終了
		slackService.stop();
	}
	public void UserUpdateBot(User user) throws IOException {
		//slackのAPI送信
		//String botToken = getKey();
		//環境変数使用
		String botToken = System.getenv("botkey");

		SlackletService slackService = new SlackletService(botToken);
		slackService.start();
		
		//slackダイレクトメッセージを送る
		String userName = user.getSlackname();
		slackService.sendDirectMessageTo(userName, userName+"さん！アカウントの変更が完了いたしました。  techmaのマイページはこちら "
		+ "https://techmah2.herokuapp.com/techmatop/techma/user");

		// slackとの接続を終了
		slackService.stop();
	}
	public void ItemStatusBot(Item item) throws IOException {
		//slackのAPI送信
		//String botToken = getKey();
		//環境変数使用
		String botToken = System.getenv("botkey");
		
		String itemStatus;
		if (item.getExhibitcansellflg() == false) {
			itemStatus = "発売中";
		} else {
			itemStatus = "キャンセル中";
		}
		SlackletService slackService = new SlackletService(botToken);
		slackService.start();
		//slackダイレクトメッセージを送る
		String userName = item.getUser().getSlackname();
		slackService.sendDirectMessageTo(userName, userName+"さん！出品のステータスの変更が完了いたしました。　商品名：  " + item.getItemname()+
		"  カテゴリー:  " + item.getCategory().getCategoryname()  + "   ステータス：  " + itemStatus + "  techmaのマイページはこちら https://techmah2.herokuapp.com/techmatop/techma/user");

		// slackとの接続を終了
		slackService.stop();
	}
	public void PurchaseStatusBot(Purchase purchase) throws IOException {
		//slackのAPI送信
		//String botToken = getKey();
		//環境変数使用
		String botToken = System.getenv("botkey");
		
		String purchaseStatus;
		if (purchase.getCansellflg() == false) {
			purchaseStatus = "発売中";
		} else {
			purchaseStatus = "キャンセル中";
		}
		SlackletService slackService = new SlackletService(botToken);
		slackService.start();
		//slackダイレクトメッセージを送る
		String userName = purchase.getUser().getSlackname();
		slackService.sendDirectMessageTo(userName, userName+"さん！購入したステータスの変更が完了いたしました。　商品名：  " + purchase.getItem().getItemname()+
		"  カテゴリー:  " + purchase.getItem().getCategory().getCategoryname()  + "   ステータス：  " + purchaseStatus + "  techmaのマイページはこちら https://techmah2.herokuapp.com/techmatop/techma/user");

		// slackとの接続を終了
		slackService.stop();
	}
}
