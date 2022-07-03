#!/bin/bash
# 构建脚本
# ---------------------


# util-starter 场景启动器
mvn -B package -DskipTests -s ./.github/settings/settings.xml --file util-starter/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file caching/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file core-web/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file data-h2/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file data-jdbc/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file data-jpa/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file data-redis/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file elasticseach/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file json/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file junit/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file kafka/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file knife4j/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file logging-logback/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file mail/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file minio/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file mybatis/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file quartz/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file rabbit-mq/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file redis-om/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file security-token/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file swagger/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file thymeleaf/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file validation/pom.xml

mvn -B package -DskipTests -s ./.github/settings/settings.xml --file version/pom.xml