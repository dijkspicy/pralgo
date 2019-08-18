#!/bin/bash

lines=$(cat words.txt | tr \\r " ")

declare -A map=()
for it in ${lines[@]};do
    if [[ -z ${map[$it]} ]];then
        map[$it]=1
    else
        num=${map[$it]}
        map[$it]=$((num+1))
    fi
done

for it in ${!map[@]};do
    echo "${it} ${map[$it]}"
done | sort -rn -k2