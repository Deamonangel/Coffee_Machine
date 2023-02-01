package tictactoe

fun String.isDigitsOnly() = all(Char::isDigit) && isNotEmpty()
fun main() {
    var n = 0
    print("Enter cells: ")
    val str = readln()
    val list = mutableListOf(
        mutableListOf(str[0], str[1], str[2]),
        mutableListOf(str[3], str[4], str[5]),
        mutableListOf(str[6], str[7], str[8])
    )
    println()

    println("-".repeat(9))
    println("| ${list[0][0]} ${list[0][1]} ${list[0][2]} |")
    println("| ${list[1][0]} ${list[1][1]} ${list[1][2]} |")
    println("| ${list[2][0]} ${list[2][1]} ${list[2][2]} |")
    println("-".repeat(9))

    while (n != 1) {
        print("Enter the coordinates: ")
        val cor = readln().split(" ")
        if (cor[0].isDigitsOnly() && cor[1].isDigitsOnly()) {
            if (cor[0] >= "1" && cor[0] <= "3") {
                if (list[cor[0].toInt() - 1][cor[1].toInt() - 1] == '_') {
                    list[cor[0].toInt() - 1][cor[1].toInt() - 1] = 'X'
                    println("-".repeat(9))
                    println("| ${list[0][0]} ${list[0][1]} ${list[0][2]} |")
                    println("| ${list[1][0]} ${list[1][1]} ${list[1][2]} |")
                    println("| ${list[2][0]} ${list[2][1]} ${list[2][2]} |")
                    println("-".repeat(9))
                    n++
                }
            } else println("Coordinates should be from 1 to 3!")
        } else println("You should enter numbers!")
    }
}
