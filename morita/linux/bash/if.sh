#!/bin/bash
if [ "$1" -eq 3 ]; then
	echo '引数は3'
elif[ "$2" -eq 5 ]; then
	echo '引数は5'
else
	echo '引数は3でも5でもありません'
fi
