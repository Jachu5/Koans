package ii_conventions

import syntax.qualifiedThis.labelsForExtensionFunctionLiterals

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate>{
    override fun compareTo(other: MyDate): Int {
        // This solution ignores leap years and 28 and 30 days month,
        // but it happens in both cases so the error is present in both cases
        val days_date1 = computeDays(year,month,dayOfMonth);
        val days_date2 = computeDays(other.year,other.month,other.dayOfMonth);
        val difference = days_date1-days_date2;

        if(difference == 0){
            return 0
        }
        if(difference >0){
            return 1
        }

        return -1


    }

    fun computeDays(year: Int, month: Int, dayOfMonth: Int):Int{
        val DAYS_YEAR = 365
        val DAYS_MONTH = 31
        return year*DAYS_YEAR+month*DAYS_MONTH+dayOfMonth

    }
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(public val start: MyDate, public val end: MyDate)
