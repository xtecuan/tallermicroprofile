#!/bin/bash

export myHost="localhost"

export myPort="8080"

export myContext="restapi"

export myPath="books"

export myUrl="http://${myHost}:${myPort}/${myContext}/${myPath}"

export book1='{"title":"This is my test book","description":"this is my book description","isbn": "12xxxxxxxx", "publisher": "None Yet", "language":"English","author":"Hayri Cicek","price": "0.00","pages":"0"}'
			 
export book2='{"title":"This is my second test book","description":"this is my second book description","isbn": "13xxxxxxxx", "publisher": "None Yet", "language":"English","author":"Hayri Cicek","price": "0.00","pages":"0"}'

export book3='{"title":"Xtecuan Book","description":"This is the book of Tadeo","isbn": "14xxxxxxxx", "publisher": "None Yet", "language":"Spanish","author":"Tadeo Rivera-Pineda","price": "0.00","pages":"0"}'



export currentBook=${book1}

if [ -n "$1" ]
then
  case $1 in
     book1)
          currentBook=${book1}
          ;;
     book2)
          currentBook=${book2}
          ;;
     book3)
          currentBook=${book3}
          ;; 
     *)
          currentBook=${book1}
          ;;
  esac
fi

echo "Calling ${myUrl}"

echo "Payload ${currentBook}"



curl -H 'Content-Type: application/json' -X PUT \
-d  http://localhost:8080/restapi/books/2

curl -i -X POST -H "Content-Type:application/json" \
  --data "${currentBook}" ${myUrl}