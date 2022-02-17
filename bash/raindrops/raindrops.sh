#!/usr/bin/env bash

flag=0

check() {
	if [ $(("$1" % $2)) -eq 0 ]; then
		echo -n "$3"
		flag=1
	fi
}

check "$1" 3 "Pling"
check "$1" 5 "Plang"
check "$1" 7 "Plong"

if [ $flag -eq 0 ]; then
	echo "$1"
fi
