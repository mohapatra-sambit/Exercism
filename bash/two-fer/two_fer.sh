#!/usr/bin/env bash

# Disable filename expansion via wildcards (*)
set -f

NAME=you
if [ $# -gt 0 ]
then NAME=$1
fi

echo "One for $NAME, one for me."
