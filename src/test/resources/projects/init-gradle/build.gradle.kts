plugins {
  java
  jacoco
  // jhipster-needle-gradle-plugins
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

jacoco {
  toolVersion = libs.versions.jacoco.get()
}

// jhipster-needle-gradle-plugins-configurations

repositories {
  mavenCentral()
  // jhipster-needle-gradle-repositories
}

group = "com.jhipster.test"
version = "0.0.1-SNAPSHOT"

ext {
  // jhipster-needle-gradle-properties
}

dependencies {
  // jhipster-needle-gradle-dependencies
  // jhipster-needle-gradle-test-dependencies
}

tasks.test {
  filter {
    includeTestsMatching("*Test.*")
    excludeTestsMatching("*IT.*")
  }
  useJUnitPlatform()
}

val integrationTest = task<Test>("integrationTest") {
  description = "Runs integration tests."
  group = "verification"
  shouldRunAfter("test")
  filter {
    includeTestsMatching("*IT.*")
    excludeTestsMatching("*Test.*")
  }
  useJUnitPlatform()
}
