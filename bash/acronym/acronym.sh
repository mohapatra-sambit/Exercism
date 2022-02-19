#!/usr/bin/env bash

main () {
	IFS=' |-|_|\*'
	read -ra words<<<"$@"
	out=''
	for word in "${words[@]}";
	do
		ch=${word:0:1}
		out=${out}${ch^}
	done
	echo "${out}"
}

main "$@"
