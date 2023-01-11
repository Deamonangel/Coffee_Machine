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
    
// check for horizontal wins
for (i in 0..6 step 3) {
    if (grid[i] == grid[i + 1] && grid[i + 1] == grid[i + 2]) {
        if (grid[i] == 'X') {
            println("X wins")
            return
        } else if (grid[i] == 'O') {
            println("O wins")
            return
        }
    }
}

// check for vertical wins
for (i in 0..2) {
    if (grid[i] == grid[i + 3] && grid[i + 3] == grid[i + 6]) {
        if (grid[i] == 'X') {
            println("X wins")
            return
        } else if (grid[i] == 'O') {
            println("O wins")
            return
        }
    }
}

// check for diagonal wins
}
