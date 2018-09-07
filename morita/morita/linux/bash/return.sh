#!/bin/bash

func()
{
	if [ ! -f "$1"]; then
	echo "$1"'ƒtƒ@ƒCƒ‹‚ª‘¶İ‚µ‚Ü‚¹‚ñ'
	return 1
	fi
	cp -p "$1" "$1".bak
	return 0
	}
	