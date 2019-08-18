#!/bin/bash

line=10
fileName="file.txt"

line=$(cat -n ${fileName} | grep ${line} | cut -d $'\t' -f 2)
[[ -z line ]] && exit 1
echo ${line}