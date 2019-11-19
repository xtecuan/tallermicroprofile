#!/bin/bash

export myHost="localhost"

export myPort="8080"

export myContext="restapi"

export myPath="books"

export myUrl="http://${myHost}:${myPort}/${myContext}/${myPath}"

if [ -n "$1" ]
then
   myUrl=${myUrl}/$1
fi

echo "Calling ${myUrl}"

curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET ${myUrl}