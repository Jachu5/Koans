package i_introduction._5_Nullable_Types

import java.io.File
import util.TODO

fun test() {
    val s: String = "this variable cannot store null references"
    val q: String? = null

    fun useNotNullableType(i: Int) {
    }
    //doesn't compile:
    //useNotNullableType(null)
}

fun struggleAgainstNPE() {
    val files = File("test").listFiles()

    //doesn't compile
    //println(files.size)

    fun checkForNull1() {
        if (files != null) {
            files.size()
        }
    }

    fun checkForNull2() {
        if (files == null) return
        files.size()
    }

    fun checkForNull3(): Int {
        if (files == null) fail()
        return files.size()
    }

    fun nullAsResultIfNullReference(): Int? {
        return files?.size()
    }

    fun defaultValueForNull(): Int {
        val size = files?.size()
        return size ?: -1
    }

    fun throwNPEIfNull(): Int {
        val f = files!!
        return f.size()
    }
}

fun fail() = throw Exception()

fun todoTask5(client: Client?, message: String?, mailer: Mailer) {

    val personalInfo =  client?.personalInfo
    val email = personalInfo?.email


    //(email != null && message != null) ?: mailer.sendMessage(email,message)
    // This is not valid, expected String not String?, sentence below allows
    // it since null checking in
    // the if statement guarantee the String

    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }

}


fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    todoTask5(client,message,mailer)
}

class Client (val personalInfo: PersonalInfo?)
class PersonalInfo (val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}