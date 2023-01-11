fun main() {
    val grid = arrayOf(
        arrayOf("X", "O", "X"),
        arrayOf("O", "X", "O"),
        arrayOf("X", "O", "X")
    )

    for (row in grid) {
        for (cell in row) {
            print("$cell ")
        }
        println()
    }
}
