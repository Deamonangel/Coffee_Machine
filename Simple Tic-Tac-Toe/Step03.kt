package tictactoe

fun main() {
    print("Enter the grid string: ")
    val input = readLine()!! // read the input from the user
    val grid = input.toCharArray() // convert the input to a char array

    // print the top border
    println("---------")

    for (i in grid.indices) {
        if (i % 3 == 0) {
            print("| ") // print the left border
        }

        print(grid[i] + " ") // print the current cell

        if ((i + 1) % 3 == 0) {
            print("|") // print the right border
            println() // go to the next line
        }
    }

    // print the bottom border
    println("---------")

    var xCount = 0
    var oCount = 0
    var emptyCount = 0
    var xWin = false
    var oWin = false

    // check for horizontal wins
    for (i in 0..6 step 3) {
        if (grid[i] == grid[i + 1] && grid[i + 1] == grid[i + 2]) {
            if (grid[i] == 'X') {
                xWin = true
            } else if (grid[i] == 'O') {
                oWin = true
            }
        }
    }

    // check for vertical wins
    for (i in 0..2) {
        if (grid[i] == grid[i + 3] && grid[i + 3] == grid[i + 6]) {
            if (grid[i] == 'X') {
                xWin = true
            } else if (grid[i] == 'O') {
                oWin = true
            }
        }
    }

    // check for diagonal wins
    if ((grid[0] == grid[4] && grid[4] == grid[8]) || (grid[2] == grid[4] && grid[4] == grid[6])) {
        if (grid[4] == 'X') {
            xWin = true
        } else if (grid[4] == 'O') {
            oWin = true
        }
    }

    // count the number of X's, O's, and empty cells
    for (i in grid.indices) {
        if (grid[i] == 'X') {
            xCount++
        } else if (grid[i] == 'O') {
            oCount++
        } else if (grid[i] == '_') {
            emptyCount++
        }
    }

    // determine if the game is impossible, X wins, O wins, draw, or not finished
    if (xWin && oWin || xCount - oCount > 1 || oCount - xCount > 1) {
        println("Impossible")
    } else if (xWin) {
        println("X wins")
    } else if (oWin) {
        println("O wins")
    } else if (emptyCount > 0) {
        println("Game not finished")
    } else {
        println("Draw")
    }
}
