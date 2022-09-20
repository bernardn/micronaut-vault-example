build:
	./gradlew jibDockerBuild

run:
	env | grep -q VAULT_TOKEN || { echo Please set VAULT_TOKEN; exit 1; }; \
	env | grep -q VAULT_ADDR || { echo You might also want to set VAULT_ADDR, it defaults to http://127.0.0.1:8200; }; \
	\
	MICRONAUT_ENVIRONMENTS=${MICRONAUT_ENVIRONMENTS:-dev} ./gradlew run

test:
	./gradlew test
