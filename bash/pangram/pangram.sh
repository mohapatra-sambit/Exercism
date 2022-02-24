#!/usr/bin/env bash

main () {
	for ch in {a..z};
	do
		if [[ "${1^^}" != *"${ch^}"* ]];
		then
			echo false
			exit 0
		fi
	done
	echo true
}

main "$@"
