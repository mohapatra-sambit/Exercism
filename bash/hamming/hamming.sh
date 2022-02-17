#!/usr/bin/env bash

if [[ $# -ne 2 ]];
then
	echo "Usage: hamming.sh <string1> <string2>"
	exit 1
fi

if [[ ${#1} -ne ${#2} ]];
then
	echo "strands must be of equal length"
	exit 1
fi

count=0
for((i=0;i<${#1};i++)); do
	if [[ "${1:$i:1}" != "${2:$i:1}" ]];
	then
		((count++))
	fi
done

echo $count
