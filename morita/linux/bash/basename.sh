#!/bin/bash

for file in *.txt
do
	name=`basename "$file" .txt`
	mv "$name".txt "$name".sh
done
