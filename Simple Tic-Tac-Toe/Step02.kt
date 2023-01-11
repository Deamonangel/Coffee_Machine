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
}
