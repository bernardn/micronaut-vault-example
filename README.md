## Java & Kotlin micronaut examples of properties retrieved from Hashicorp Vault

VAULT_TOKEN=your-valid-vault-token make run

At startup, micronaut will load the following secrets :

- application
- my-app
- application/dev
- my-app/dev

And merge the keys, the next one overwriting the previous :  

    23:21:51.281 [main] INFO  i.m.d.c.c.DistributedPropertySourceLocator - Resolved 2 configuration sources from client: compositeConfigurationClient(vault-config-client-v2)

Then the app will look up after the HELLO key.

## Micronaut 3.6.3 Documentation

- [User Guide](https://docs.micronaut.io/3.6.3/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.6.3/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.6.3/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


