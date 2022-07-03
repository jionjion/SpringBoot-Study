#!/bin/bash

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file core-web/pom.xml
