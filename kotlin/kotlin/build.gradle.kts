import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/* 构建插件 */
plugins {
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

/* 坐标信息 */
group = "top.jionjion"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

/* 仓库地址 */
repositories {
    /* 阿里云仓库地址 */
    maven("https://maven.aliyun.com/repository/public/")
    /* 本地配置 MavenLocal */
    mavenLocal()
    /* Maven 中央仓库 */
    mavenCentral()
}

/* 依赖坐标 */
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

/* 任务列表...编译 */
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

/* 任务列表...测试 */
tasks.withType<Test> {
    useJUnitPlatform()
}
