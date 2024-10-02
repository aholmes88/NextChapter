package com.example.nextchapter.utils

import java.security.MessageDigest
import java.security.SecureRandom

// This is for Hashing and adding the salt to it
object HashUtils {

    //To Do
    //[] make function to hash the password using sha -256 and include salt
    // []make function to make salt
    // }

    fun generateSalt(): String {
        val salt = ByteArray(16)
        SecureRandom().nextBytes(salt)
        return salt.joinToString("") {
            "%02x".format(it)
        }
    }

    fun hashPassword(password: String, salt: String): String {
        val bytes = MessageDigest
            .getInstance("SHA-256")
            .digest(password.toByteArray())

        return bytes.joinToString("") {
            "%02x".format(it)
        }
    }
}
