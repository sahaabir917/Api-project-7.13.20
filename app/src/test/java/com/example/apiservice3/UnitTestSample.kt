package com.example.apiservice3

import android.content.Context
import com.example.apiservice3.Testingclass.EmailValidator
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner


private const val FAKE_STRING = "HELLO_WORLD"

class UnitTestSample {

    lateinit var  unittest : EmailValidator

    init {
       unittest = EmailValidator()
    }

    @Test
    fun readStringFromContext_LocalizedString() {
        assertFalse(unittest.isValidEmail("sahaabir917.com"))
    }

}