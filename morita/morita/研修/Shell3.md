#パラメータ展開＄シリーズで色々見れるのが特徴的。

コマンドで直接OSを操作することができる。
深い部分をいじれる分

似たようなものでC言語がある
シェルは性能が遅い
他の言語の方が早い。

\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#外部コマンド

sleep 外部コマンドとしてShellで書く
処理がかかる処理の前
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#エクスプレッション
expr
計算する
計算結果0でも空文字で無い場合終了ステータス0になる
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#セド


\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

#file='hello.txt'
#expr "$file" : '..\(...\)'
ファイルどこの文字を表示するか
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#basename
[ec2-user@ip-30-0-10-87 0831]$ file="/home/ec2-user/0831/for.txt"
[ec2-user@ip-30-0-10-87 0831]$ echo "$file"
/home/ec2-user/0831/for.txt
[ec2-user@ip-30-0-10-87 0831]$ basename $file
for.txt
[ec2-user@ip-30-0-10-87 0831]$ basename $file .txt
for
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#dirname
パスが取れる
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#cat 全部開く
#more　
#less　一個ずつページで見ていく
#tail
#haed
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
ディスク使用量
df -h
top
netstat
free
sar外部コマンドインストールしないと使えない
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#ls -ltr
rをつけることにより更新した順に表示される
#ll -r
#ln オプション
#touch タイムスタンプ更新もできる
オプションからタイムスタンプ変えられる。
#diff
#grep -n 何行目か
#grep -v 抜いて表示することがきる

#find / -name *.sh 2> /dev/null | wc -l*
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#sed


sed 's/ec2-user/e2c-user/g' logfile.log > sed.
log

#gで繰り返し　同じ行でも処理される

[ec2-user@ip-30-0-10-87 0904]$ cat sed.log
/home/e2c-user/0831
total 44
-rw-r--r--. 1 e2c-user e2c-user  78 Aug 31 03:57 10times.sh
-rw-r--r--. 1 e2c-user e2c-user 456 Aug 31 04:44 backup.
-rw-r--r--. 1 e2c-user e2c-user  76 Aug 31 04:10 calc.sh
-rwxrwxrwx. 1 e2c-user e2c-user 172 Aug 31 02:19 case.sh
-rwxrwxrwx. 1 e2c-user e2c-user  64 Aug 31 02:49 for.sh
-rw-r--r--. 1 e2c-user e2c-user 154 Aug 31 02:11 if.sh
-rw-rw-r--. 1 e2c-user e2c-user  20 Aug 31 05:16 logfile.log
-rw-r--r--. 1 e2c-user e2c-user  63 Aug 31 05:11 reidairect.sh
-rw-r--r--. 1 e2c-user e2c-user 456 Aug 31 04:44 select.sh
-rw-r--r--. 1 e2c-user e2c-user  65 Aug 31 04:59 sub.sh
-rw-r--r--. 1 e2c-user e2c-user 110 Aug 31 04:24 while.sh
/home/e2c-user/0831
total 44
-rw-r--r--. 1 e2c-user e2c-user  78 Aug 31 03:57 10times.sh
-rw-r--r--. 1 e2c-user e2c-user 456 Aug 31 04:44 backup.
-rw-r--r--. 1 e2c-user e2c-user  76 Aug 31 04:10 calc.sh
-rwxrwxrwx. 1 e2c-user e2c-user 172 Aug 31 02:19 case.sh
-rwxrwxrwx. 1 e2c-user e2c-user  64 Aug 31 02:49 for.sh
-rw-r--r--. 1 e2c-user e2c-user 154 Aug 31 02:11 if.sh
-rw-rw-r--. 1 e2c-user e2c-user 688 Aug 31 05:20 logfile.log
-rw-r--r--. 1 e2c-user e2c-user  64 Aug 31 05:20 reidairect.sh
-rw-r--r--. 1 e2c-user e2c-user 456 Aug 31 04:44 select.sh
-rw-r--r--. 1 e2c-user e2c-user  65 Aug 31 04:59 sub.sh
-rw-r--r--. 1 e2c-user e2c-user 110 Aug 31 04:24 while.sh
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
正規表現を使うと
5文字でJから始まりRで終わるという指定する
事ができる。
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#配列
week=(Sunday Monday Tuesday Wendnesday Thursday Friday Saturday)
[ec2-user@ip-30-0-10-87 0904]$ echo ${week[@]}
Sunday Monday Tuesday Wendnesday Thursday Friday Saturday
[ec2-user@ip-30-0-10-87 0904]$


for idx in 0 1 2 3 4 5 6
do
  echo ${week[idx]}
done
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#`array 配列の英語
[ec2-user@ip-30-0-10-87 0904]$ save=("${week[@]}")
[ec2-user@ip-30-0-10-87 0904]$ echo "${save[@]}"
Sunday Monday Tuesday Wendnesday Thursday Friday Saturday
[ec2-user@ip-30-0-10-87 0904]$ unset 'week[1]'
[ec2-user@ip-30-0-10-87 0904]$ echo "${week[@]}"
Sunday Tuesday Wendnesday Thursday Friday Saturday
[ec2-user@ip-30-0-10-87 0904]$ unset week
[ec2-user@ip-30-0-10-87 0904]$ echo "${week[@]}"

[ec2-user@ip-30-0-10-87 0904]$ echo "${save[@]}"
Sunday Monday Tuesday Wendnesday Thursday Friday Saturday
[ec2-user@ip-30-0-10-87 0904]$`

#参照代入
#代入

#配列
グループを入れて配列にインデックスで取り出すことができる
データの集まり

java string int 決まっている
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#シェルの定石

解釈回数
eval eval \\\ \\\
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

[ec2-user@ip-30-0-10-87 0904]$ date "+%Y/%m/%d-%H.%M.%S"

#hosts
ブラウザにドメイン名を打って
hostを見て書いてあれば書いてあるIPに飛ばす

#127.0.0.1
#localhost
ループバックアドレス
最初から取られている
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#tar
#tar -cvf test.tar ./*

#tar -zcvf test.tar.gz ./*
オプションにZでジップにしているからファイルサイズ小さくなる。
#ファイル解凍
#tar -zxvf test.tar.gz
ボーンジップ圧縮率高い
#tar -jcvf ./tmp/test.tar.bz2 ./*
外部コマンドでインストールしてないから
#sudo yum install bzip2
解凍
#tar jxf test.tar.bz2
tarファイル表示
#tar tvf test.tar.bz2
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
iconv
iconv -f utf8 -t sjis clack.txt > sjis.txt
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
scp 35.214. @フォルダ名 パスワード
ftp
sftpコマンド
cut
sed
awk

#cut -d デミリター

,で区切って6番目だけ切り取り
cut -d ","  -f 6 KEN_300.csv > cut.csv
cut -d ","  -f 7,8,9,10 KEN_300.csv > cut.csv


#sed 's/札幌市東区/ドサンコ/g' cut.csv
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#awk -F'[,]' '{print $7,$8,$9}' KEN_300.csv | head
-Fフィールドセパレーター
デミリターと同様
