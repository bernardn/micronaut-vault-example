package example.micronaut;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Value;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("${hello.controller.path:/}") // <1>
public class HelloController {

    private final String someValue;
    public HelloController(@Value("${hello.value}") String someValue) { this.someValue = someValue; }

    @Get // <2>
    public String hello() { return someValue; }

}
