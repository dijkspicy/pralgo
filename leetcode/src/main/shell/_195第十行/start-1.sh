#!/bin/bash

line=10
fileName="file.txt"
IFS=$'\n'
fileContent=($(cat ${fileName}))
for ((i=0;i<${#fileContent[@]};i++));do
    item=${fileContent[i]}
    [[ i -eq $((line-1)) ]] && echo ${item}
done

[[ i -lt $((line-1)) ]] && exit 1