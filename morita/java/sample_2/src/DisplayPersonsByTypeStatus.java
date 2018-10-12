/* DisplayPersonsByTypeStatus.java
 */

/* DisplayPersonsByTypeStatus
 * 問2:変更するクラス
 */
public class DisplayPersonsByTypeStatus extends ConsoleStatus {

	// フィールド
	private String work;
	private PersonList plist;
	private PersonList selectedList;
	private DisplayPersonStatus next;

	// 問2:追加部分
	// リストを表示する範囲の先頭位置（初期値＝0）
	private int startIdx;

	/**
	 * コンストラクタ DisplayPersonsByTypeStatus
	 * @param String firstMess
	 * @param String promptMess
	 * @param boolean IsEndStatus
	 * @param PersonList plist
	 * @param DisplayPersonStatus next
	 */
	DisplayPersonsByTypeStatus( String firstMess, String promptMess,
	                     boolean IsEndStatus,
	                     PersonList plist, DisplayPersonStatus next ) {
		super( firstMess, promptMess, IsEndStatus );
		this.work = "";
		this.plist = plist;
		this.selectedList = null;
		this.next = next;
		// 問2:追加部分
		this.startIdx = 0;
	}

	// 最初に出力するメッセージを表示する
	/** displayFirstMess
	 * @throws Exception
	 */
	public void displayFirstMess() throws Exception {
		displayList();
		super.displayFirstMess();
	}

	/** setWork
	 * @param String work
	 */
	public void setWork( String work ) {
		this.work = work;
		// 問2:追加部分
		startIdx = 0;
	}

	// 入力された職種をもつ従業員のレコードだけを
	// 取り出す処理
	/**
	 * displayList
	  */
	public void displayList() {
		// 問2:追加部分
		Person p;

		// 入力された職種をもつ従業員のレコードだけを
		// selectedListに取り出す
		selectedList = plist.searchByTypes( work );
		// selectedListの件数＝0ならば当該職種をもつ
		// 従業員はいないと表示
		if( selectedList.size() <= 0 )
			System.out.println( "従業員が存在しません。" );
		// 問2:変更部分
		// リストを表示する範囲の先頭位置から
		// 先頭位置＋2の位置のレコードまでを表示
		// (リストの末尾に達したときは末尾のレコードまでを表示)
		else {
			for( int i = startIdx;
			     i < (startIdx + 3) && i < selectedList.size(); i++ ) {
				p = (Person)selectedList.getRecord( i );
				System.out.println( p.toString() );
			}
		}
	}

	// 次の状態に遷移することを促すためのメッセージの表示
	/** getNextStatus
	 * @param String s
	 * @return ConsoleStatus
	 */
	public ConsoleStatus getNextStatus( String s ) {
		// 数値が入力された場合，その数値と同じIDをもつ
		// レコードがselectedListにあるかどうか判定し，
		// あればそれを次の状態DisplayPersonStatusに渡す
		try {
			int i = Integer.parseInt( s );
			Person p = selectedList.get( i );
			if( p == null )
				return this;
			else {
				next.setPersonRecord( p );
				return next;
			}
		} catch( NumberFormatException e ) {
			// 問2:変更部分
			// "N"が入力された場合:
			// リストを表示する範囲の先頭位置に3加算
			// ただし，3加算した値がリストの大きさを超える場合は
			// 先頭位置0に戻す
			if( s.equals("N") ) {
				if( (startIdx + 3) < selectedList.size() )
					startIdx += 3;
				else
					startIdx = 0;
			}
			// "P"が入力された場合:
			// リストを表示する範囲の先頭位置に3減算
			// ただし，3減算した値がマイナスになる場合は
			// リストの大きさ－3の位置にする
			if( s.equals("P") ) {
				if( (startIdx - 3) < 0 )
					startIdx = (selectedList.size() - 3) < 0 ? 0 : selectedList.size() - 3;
				else
					startIdx -= 3;
			}

			return super.getNextStatus( s );
		}
	}
}
