package alloba.mono

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class AppKt

fun main(args: Array<String>) {
    runApplication<AppKt>(*args)
}

//@RestController class TestController {F
//    @GetMapping("test") fun test(): String = "test"
//}