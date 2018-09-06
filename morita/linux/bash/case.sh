#!/bin/bash

case $1 in
	start)
		echo '開始します'
		;;
		stop)
		echo '停止します'
		;;
		*)
		echo '引数にstartかstopをつけてください'
		;;
	esac
	