#!/bin/bash

export myGroupId="sv.org.devfest"
export myArtifactId="book-store-client"

mvn archetype:generate -DarchetypeGroupId=com.kodnito -DarchetypeArtifactId=kodnito-microprofile-archetype -DarchetypeVersion=1.0.1 -DgroupId=${myGroupId} -DartifactId=${myArtifactId} -Dversion=1.0-SNAPSHOT

