@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    return when {
        (number % 10 + number / 10 % 10) == (number / 100 % 10 + number / 1000 % 10) -> true
        else -> false
    }
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    return when {
        x1 == x2 || y1 == y2 || (abs(x1 - x2) == abs(y1 - y2)) -> true
        else -> false
    }
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    var isLeap = 0
    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
        isLeap = 1
    return when (month) {
        1 -> 31
        2 -> 28 + isLeap
        3 -> 31
        4 -> 30
        5 -> 31
        6 -> 30
        7 -> 31
        8 -> 31
        9 -> 30
        10 -> 31
        11 -> 30
        else -> 31
    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean = when {
    sqr(x1 - x2) + sqr(y1 - y2) <= sqr(r1 - r2) && r1 <= r2 -> true
    else -> false
}

fun max3(a: Int, b: Int, c: Int): Int {
    var max = a
    if (b > max)
        max = b
    if (c > max)
        max = c
    return max
}

fun min3(a: Int, b: Int, c: Int): Int {
    var min = a
    if (b < min)
        min = b
    if (c < min)
        min = c
    return min
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val maxRS = max(r,s)
    val minRS = min(r,s)
    return when {
        (a * b <= r * s && max(a,b) <= maxRS && min(a,b) <= minRS
        || a * c <= r * s && max(a,c) <= maxRS && min(a,c) <= minRS
        || b * c <= r * s && max(b,c) <= maxRS && min(b,c) <= minRS) -> true
        else -> false
    }
}
