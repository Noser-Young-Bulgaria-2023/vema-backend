plugins {
	id 'java'
	id 'org.springframework.boot' version '3.0.6'
	id 'io.spring.dependency-management' version '1.1.0'
	id "org.sonarqube" version "4.0.0.2929"
}

group = 'ch.noseryoung'
version = '1.0.0'
sourceCompatibility = '17'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation group: 'org.springframework.data', name: 'spring-data-mongodb'
	implementation 'org.springframework.boot:spring-boot-starter-data-mongodb:3.0.6'
	implementation 'org.mapstruct:mapstruct:1.5.5.Final'
 
    annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.5.Final'

	// Testing
	testImplementation 'com.h2database:h2'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
	testImplementation "org.mockito:mockito-core:3.+"
	testImplementation 'org.junit.jupiter:junit-jupiter:5.7.1'

	// AssertJ
	testImplementation 'org.assertj:assertj-core'

}

tasks.named('test') {
	useJUnitPlatform()
}

sonarqube {
  properties {
    property "sonar.projectKey", "Noser-Young-Bulgaria-2023_vema-backend"
    property "sonar.organization", "noser-young-bulgaria-2023"
    property "sonar.host.url", "https://sonarcloud.io"
  }
}
