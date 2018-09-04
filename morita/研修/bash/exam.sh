#!/bin/sh

if [ $# -ne 1 ]; than
	echo "Usage: $0 file" 1>$2
	exit 1
fi
cp "$1" "$1".bak






