## Kotlin micronaut examples of properties retrieved from Hashicorp Vault

    VAULT_TOKEN=your-valid-vault-token make run

At startup, micronaut will load the following secrets :

- application
- my-app
- application/dev
- my-app/dev

And merge the keys, the next one overwriting the previous.  

    11:39:58.573 [main] INFO  i.m.context.DefaultBeanContext - Reading bootstrap environment configuration
    11:39:59.151 [main] INFO  i.m.d.c.c.DistributedPropertySourceLocator - Resolved 4 configuration sources from client: compositeConfigurationClient(vault-config-client-v2)
    11:39:59.216 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 796ms. Server Running: http://localhost:8080

Then the app will look up after the HELLO key.


## Micronaut 3.6.3 Documentation

- [User Guide](https://docs.micronaut.io/3.6.3/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.6.3/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.6.3/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


