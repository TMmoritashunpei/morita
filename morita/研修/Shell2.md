外部コマンド
vimダウンロードして使う
##########################
組み込みコマンド
そのまま使えるコマンド
##########################
PHP
ドイツでできた
当時はJAVA主流
いまだに使われている

HTMLと親和性が高い
画面のプログラム作りやすい
色々なシステム作るのにはJava
簡単なWEBサイトはPHP

JS系
リダクト
NODE

##########################
echo

-e

正規表現使うときに-e
エスケープシーケンス

echo \n
など使える
echo -e 'hello \f world'
echo -e 'hello \a world'
ビープ音出る
##########################
kill

プロセスを切る
IDを指定すると強制終了することができる
ps -aux

kill使うとき
邪魔なプロセスが引っかかってしまうとき

ミドルウェア
起動しているのにコンフリクトして動かないときにkillする時もある
kill -9　は強制kill
##########################
printf '%02x %02x %02x %02x\n' 192 168 10 21
c0 a8 0a 15

printf '%d, %d, %d, %d,\n' 0xc0 oxa8 0x0a 0x15
192.168.10.21
##########################
pwd

dir=`pwd` コマンドはバッククオート
echo "$dir"

TEST
[条件式]
オプションいくつかある
##########################
true
単に0の終了ステータスを返す
##########################
組み込みコマンド
ulimit
リソース制限
プロセス毎に
cpuなどどれくらい使っていいといいう設定をすることができる。

tc resource制限かけられる。
トラフィックコントロール
#kill
#TEST
演算子
##########################
変数の代入
#'[ec2-user@ip-30-0-10-87 0831]$ a='*** hello world !! ***'
[ec2-user@ip-30-0-10-87 0831]$ b=$a
[ec2-user@ip-30-0-10-87 0831]$ echo "$b"
*** hello world !! ***
[ec2-user@ip-30-0-10-87 0831]$ echo $b
10times.sh backup. calc.sh case.sh continue.sh eval.sh eval.txt for.sh func.sh if.sh logfile.log reidairect.sh return.sh select.sh src_test.sh sub.sh while.sh hello world !! 10times.sh backup. calc.sh case.sh continue.sh eval.sh eval.txt for.sh func.sh if.sh logfile.log reidairect.sh return.sh select.sh src_test.sh sub.sh while.sh
[ec2-user@ip-30-0-10-87 0831]$ a='*** hello world !! ***
[ec2-user@ip-30-0-10-87 0831]$ b=$a
[ec2-user@ip-30-0-10-87 0831]$ echo $b
10times.sh backup. calc.sh case.sh continue.sh eval.sh eval.txt for.sh func.sh if.sh logfile.log reidairect.sh return.sh select.sh src_test.sh sub.sh while.sh hello world !! 10times.sh backup. calc.sh case.sh continue.sh eval.sh eval.txt for.sh func.sh if.sh logfile.log reidairect.sh return.sh select.sh src_test.sh sub.sh while.sh
[ec2-user@ip-30-0-10-87 0831]$

""が無いと
*がコマンドと認識してしまう。
echo * 同じこと
#''だと＄ｂが表示されている。

###########################
位置パラメータ

$1 $2 番号によって場所を参照できる

###########################
特殊パラメータ　$@
peramATtest.sh
for arg in "$@"
do
echo "$arg"
done

$@ 呼び出し専用
###########################

TEMPFILE=/home/ec2-user/morita$$
nkf -Se "$file" > "$TEMPFILE"
mv -f "$TEMPFILE" "$file"
###########################
export
ログインシェルに書き込む
LANG＝C
###########################

[ec2-user@ip-30-0-10-87 ~]$ LANG=ja_JP.utf8
[ec2-user@ip-30-0-10-87 ~]$ date
2018年  9月  3日 月曜日 05:20:43 UTC
###########################
ps1 ps2
プロンプトをなくす
[ec2-user@ip-30-0-10-87 ~]$
変えることができる
PS1='[\u@\h \w]\$ '
[guest@myhost doc]$
###########################
IFS
フィールドセパレーター
フィールド
単語分割に設定されている
デフォルト
スペース、タブ、改行
csv
カンマセパレートバリュー
カンマで区切る
###########################
パラメータのデフォルト値を指定する
cp file "$(1:-/tmp)"
1は第一引数
第一引数を指定していない場合は/tmp配下にファイルをコピーする
###########################
${=} 代入
${+}パラメータが設定されている場合のみ指定の値に展開する。
${#}パラメータの値の文字列の長さを求める
echo ${#HOME}

wc コマンド
[ec2-user@ip-30-0-10-87 ~]$ wc -l KEN_ALL.CSV
124178 KEN_ALL.CSV
行数を調べることができる

一定のパターンを取り除く
[ec2-user@ip-30-0-10-87 ~]$ echo "${HOME##*/}"
ec2-user
[ec2-user@ip-30-0-10-87 ~]$ echo "${HOME#*/}"
home/ec2-user

[ec2-user@ip-30-0-10-87 ~/0903]$ echo "${here:2:5}"
ome/e
二文字から5文字

わたすほうがパラメーター
受け取るほうが引数

置換する
[ec2-user@ip-30-0-10-87 ~/0903]$ echo "${here/ec2-user/e2c-user}"
/home/e2c-user/0903
[ec2-user@ip-30-0-10-87 ~/0903]$ echo "${here/home/away}"
/away/ec2-user/0903
[ec2-user@ip-30-0-10-87 ~/0903]$ echo "${here/home/home}"
/home/ec2-user/0903
[ec2-user@ip-30-0-10-87 ~/0903]$ echo "${here/ec2-user/ec2-user}"
/home/ec2-user/0903
[ec2-user@ip-30-0-10-87 ~/0903]$

[ec2-user@ip-30-0-10-87 ~/0903]$ echo ${!H@}
HISTCMD HISTCONTROL HISTFILE HISTFILESIZE HISTSIZE HOME HOSTNAME HOSTTYPE
[ec2-user@ip-30-0-10-87 ~/0903]$ echo ${!H*}
HISTCMD HISTCONTROL HISTFILE HISTFILESIZE HISTSIZE HOME HOSTNAME HOSTTYPE
[ec2-user@ip-30-0-10-87 ~/0903]$ echo ${!h*}
here
[ec2-user@ip-30-0-10-87 ~/0903]$


''
$も文字列に
""
パラメータ展開とコマンド置換``はしてくれる
\ 文字
[ec2-user@ip-30-0-10-87 ~/0903]$ echo "\$HOMEの値は$HOME"
$HOMEの値は/home/ec2-user

[ec2-user@ip-30-0-10-87 ~/0903]$ echo '\$HOMEの値は$HOME'
\$HOMEの値は$HOME

""をつけるときはスペースが区切り文字と認識される
grep　で文字列探すときに使える

\次の一文字の特殊を打ち消す

[ec2-user@ip-30-0-10-87 ~/0903]$ echo `cal 9 2018`
September 2018 Su Mo Tu We Th Fr Sa 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
[ec2-user@ip-30-0-10-87 ~/0903]$ echo "`cal 9 2018`"
   September 2018
Su Mo Tu We Th Fr Sa
                   1
 2  3  4  5  6  7  8
 9 10 11 12 13 14 15
16 17 18 19 20 21 22
23 24 25 26 27 28 29
30
########################

パス名展開
cp ???.txt /home/ec2-User
cp *.txt /home/ec2-User
指定した条件の一文字にマッチさせる
cp [a-z].txt /home/ec2-User
########################
プロセス置換
diff <(sort file1) <(sort file2)

########################
単語分割(IFS)

[ec2-user@ip-30-0-10-87 ~/0831]$ echo $"$PATH"
/usr/local/bin:/usr/bin:/usr/local/sbin:/usr/sbin:/home/ec2-user/.local/bin:/home/ec2-user/bin
[ec2-user@ip-30-0-10-87 ~/0831]$ IFS_SAVE=$IFS
[ec2-user@ip-30-0-10-87 ~/0831]$ echo $IFS_SAVE

[ec2-user@ip-30-0-10-87 ~/0831]$ IFS_SAVE=$IFS
[ec2-user@ip-30-0-10-87 ~/0831]$ echo "$IFS_SAVE"


[ec2-user@ip-30-0-10-87 ~/0831]$ IFS=:
[ec2-user@ip-30-0-10-87 ~/0831]$ set $PATH
[ec2-user@ip-30-0-10-87 ~/0831]$ IFS=$IFS_SAVE
[ec2-user@ip-30-0-10-87 ~/0831]$ echo "$1"
/usr/local/bin
[ec2-user@ip-30-0-10-87 ~/0831]$ echo "$2"
/usr/bin
[ec2-user@ip-30-0-10-87 ~/0831]$ echo "$3"
/usr/local/sbin

:で区切るようにsetコマンドを使っている
区切られたものがそれぞれ引数として入っている
###########################

リダイレクト
cat < file
soft
###########################

###########################
echo "内容" > file
vi使わなくてもtouch使わなくてもファイル作成できる

リダイレクト
0,1,2,
0　標準入力
1　標準出力
2　標準エラー出力

find / -name bin 2> /dev/null
2標準エラー出力
エラーが出てるものを/dev/NULL(ゴミ箱みたいなもの)
すっきり表示することができる

sh func.sh &> funk-log
sh func.sh 2>&1 funk-log
同じ結果になるが
正規の表現の2番目を使ったほうが良い。
sh func.sh 2>&1 | tee funk-log
ログに落としながら実行できる
