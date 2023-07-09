package org.alloba.exampleapp

import org.alloba.exampleapp.testing.TestingController
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class ExampleAppApplicationTests {

    @Autowired lateinit var testingController: TestingController

    @Test
    fun contextLoads() {
        val result = testingController.test()
        assertEquals("test", result)
    }

}
