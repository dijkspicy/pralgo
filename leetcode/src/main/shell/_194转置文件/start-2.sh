#!/bin/bash

fileName="file.txt"
IFS=$'\n'
fileLines=($(cat ${fileName}))

IFS=' '
rowNum=${#fileLines[@]}
firstLine=(${fileLines[0]})
columnNum=${#firstLine[@]}

declare rows
for ((i=0;i<$columnNum;i++));do
    echo "$i col"
    oneRow=$(cat ${fileName} | cut -d ' ' -f $i)
    [[ -z ${rows} ]] && rows=${oneRow} || rows="${rows}\n${oneRow}"
done
echo ${rows}