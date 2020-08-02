package calculator.infrastructure

const val SIMPLE_DELIMITER = ",|:"
val SIMPLE_DELIMITER_REGEX = Regex(SIMPLE_DELIMITER)
val NUMERIC_REGEX = Regex("[0-9]")
val DELIMITER_REGEX = Regex("//(.)\n(.*)")

fun validate(string: String?): String {
    if (string.isNullOrBlank()) {
        return "0"
    }
    return string
}

fun matchResult(string: String): MatchResult? {
    return DELIMITER_REGEX.find(string)
}

fun parse(string: String, customDelimiter: String): List<String> {

    if (customDelimiter == SIMPLE_DELIMITER) {
        return string.split(SIMPLE_DELIMITER_REGEX)
    }
    return matchResult(string)!!.groupValues[2].split(customDelimiter)
}

fun findCustomDelimiter(string: String): String {
    val matchResult = matchResult(string)
    if (matchResult != null && matchResult.groupValues[1].isNotBlank()) {
        return matchResult.groupValues[1]
    }
    return SIMPLE_DELIMITER
}

class Number(val number: String) {

    fun isNatural(): Boolean {
        if (NUMERIC_REGEX.matches(number)) {
            return true
        }
        throw IllegalArgumentException("숫자가 아닙니다")
    }
}
