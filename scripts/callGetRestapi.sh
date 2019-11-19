#!/bin/bash

export APP=$(dirname $(realpath $0))
source ${APP}/env.sh

if [ -n "$1" ]
then
   myUrl=${myUrl}/$1
fi

echo "Calling ${myUrl}"

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET ${myUrl}