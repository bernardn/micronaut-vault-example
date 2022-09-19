package example.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

import io.micronaut.context.annotation.Value


@Controller("\${hello.controller.path}") // <1>
class HelloController (@Value("\${hello.value}") val secretValue: String) {
    @Get// <2>
    @Produces(MediaType.TEXT_PLAIN) // <3>
    fun index(): String {
        return secretValue
    }
}
