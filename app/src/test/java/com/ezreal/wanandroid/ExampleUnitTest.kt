package com.ezreal.wanandroid

import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        runBlocking {
            launch{
                print("A \n")
            }

            print("D \n")

            coroutineScope {
                launch {
                    print("B \n")
                }

                print("C \n")
            }


        }

        assertEquals(4, 2 + 2)
    }


    @Test
    fun testCoroutine() {
        runBlocking {
            launch {
                print("A\n")
            }

            print("B\n")
        }
        assertEquals(2, 1 + 1)
    }

    suspend fun supWorking(){
        withContext(Dispatchers.IO){

        }
    }
}