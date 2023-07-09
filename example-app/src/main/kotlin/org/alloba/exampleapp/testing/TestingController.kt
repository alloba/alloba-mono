package org.alloba.exampleapp.testing

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestingController {
    @GetMapping("test") fun test() = "test"
}