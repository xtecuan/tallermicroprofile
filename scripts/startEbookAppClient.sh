#/bin/bash

export APP=$(dirname $(realpath $0))

cd ../book-store-client/

mvn clean package tomee:run -Dtomee-plugin.http=8081