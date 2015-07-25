package i_introduction._2_Default_And_Named_Params

import util.TODO
import i_introduction._1_Functions.task1

fun todoTask2_2(conllection: Collection<Int>) : String {
    return conllection.joinToString(", ","{","}")
}

fun task2_2(collection: Collection<Int>): String {
    return todoTask2_2(collection)
}
