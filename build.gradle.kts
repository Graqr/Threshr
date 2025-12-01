plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.25"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.25"
    id("com.google.devtools.ksp") version "1.9.25-1.0.20"
    id("groovy") 
    id("io.micronaut.library") version "4.4.4"
    id("io.micronaut.test-resources") version "4.4.4"
}

version = "0.1.0"
group = "com.graqr"

val kotlinVersion = project.properties["kotlinVersion"]
val dataFakerVersion = "2.4.2"
val log4jBomVersion = "2.24.1"
val groovySqlVersion = "4.0.24"
repositories {
    mavenCentral()
}

dependencies {
    ksp("io.micronaut:micronaut-http-validation")
    ksp("io.micronaut.serde:micronaut-serde-processor")
    ksp("io.micronaut.data:micronaut-data-processor")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("org.apache.logging.log4j:log4j-api")
    implementation(platform("org.apache.logging.log4j:log4j-bom:${log4jBomVersion}"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    testImplementation("net.datafaker:datafaker:${dataFakerVersion}")
    testImplementation("org.apache.groovy:groovy-sql:${groovySqlVersion}")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("org.apache.logging.log4j:log4j-core")
    runtimeOnly("org.apache.logging.log4j:log4j-slf4j-impl")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("org.yaml:snakeyaml")
}


java {
    sourceCompatibility = JavaVersion.toVersion("17")
}

graalvmNative.toolchainDetection = false

micronaut {
    runtime("netty")
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("com.graqr.*")
    }
    testResources {
        additionalModules.add("jdbc-postgresql")
    }
}



