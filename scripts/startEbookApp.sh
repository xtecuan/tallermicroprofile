#/bin/bash

export APP=$(dirname $(realpath $0))

cd ../book-store/

mvn clean package payara-micro:start