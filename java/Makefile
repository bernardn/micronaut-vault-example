build:
	./mvnw package

package: build

run:
	env | grep -q VAULT_TOKEN || { echo Please set VAULT_TOKEN; exit 1; }; \
	\
	MICRONAUT_ENVIRONMENTS=${MICRONAUT_ENVIRONMENTS:-dev} ./mvnw -e mn:run

test:
	./mvnw test
