plugins {
	id 'java'
	id 'org.springframework.boot' version '3.0.6'
	id 'io.spring.dependency-management' version '1.1.0'
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


	runtimeOnly 'org.postgresql:postgresql'

	// Testing
	testImplementation 'com.h2database:h2'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
	testImplementation "org.mockito:mockito-core:3.+"

	// AssertJ
	testImplementation 'org.assertj:assertj-core'

}

tasks.named('test') {
	useJUnitPlatform()
}
