plugins {
    id 'java'
    id 'io.qameta.allure' version '2.11.2'

}

group 'org.example24'
version '1.0-SNAPSHOT'

allure { //подключение отчета аллюр
    report {
        version.set("2.27.0")
    }
    adapter { //отвечает за появление папочки билд-аллюр-резулт.
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.27.0") //версия интеграции фреймворка и аллюра
            }
        }
    }
}

repositories {
    mavenCentral()
}

compileJava {
    options.encoding = 'UTF-8'
}
compileTestJava {
    options.encoding = 'UTF-8'
}

dependencies {
    testImplementation(
            'org.junit.jupiter:junit-jupiter:5.9.2',
            'com.codeborne:selenide:6.19.1',
            'com.github.javafaker:javafaker:1.0.2',
            'org.slf4j:slf4j-simple:2.0.7'
    )
}

test {
    useJUnitPlatform()
}

compileJava.options.encoding = 'UTF-8'
tasks.withType(JavaCompile){
    options.encoding = 'UTF-8'
}
