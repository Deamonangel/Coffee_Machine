package Machine

class CoffeeMachine(
    var water: Int = 200,
    var milk: Int = 50,
    var coffeeBeans: Int = 15,
    var cups: Int = 1,
) {
    enum class CoffeeType(
        val water: Int,
        val milk: Int,
        val coffeeBeans: Int,
        val cups: Int,
    )

    private fun areResourcesEnoughFor(coffeeType: CoffeeType): Boolean =
        water >= coffeeType.water && milk >= coffeeType.milk && coffeeBeans >= coffeeType.coffeeBeans && cups >= coffeeType.cups

    fun showResources() {

    }

    //region Step
    //Starting Point
    private fun printStatsStep0() {
        fun main() {
            println("Hello, world!")
            println("Starting to make a coffee")
            println("Grinding coffee beans")
            println("Boiling water")
            println("Mixing boiled water with crushed coffee beans")
            println("Pouring coffee into the cup")
            println("Pouring some milk into the cup")
            println("Coffee is ready!")
        }
    }

    //Step 1
    private fun printStatsStep1() {
        println("Write how many ml of water do you want to add: ")
        val numberOfCups = readln().toInt()
        println("For $numberOfCups  cups of coffee you will need:")
        val numberOfWater = 1000 * numberOfCups
        println("$numberOfWater ml of water")
        val numberOfMilk = 50 * numberOfCups
        println("$numberOfMilk ml of milk")
        val numberOfBeans = 15 * numberOfCups
        println("$numberOfBeans g of coffee beans")
    }

    //Step 2
    private fun printStatsStep2() {
        println()
        println("Write how many ml of water do you want to add: ")
        val numberOfCups = readln().toInt()
        println("For $numberOfCups  cups of coffee you will need:")
        val numberOfWater = 200 * numberOfCups
        println("Write how many ml of milk the coffee machine has:")
        val numberOfMilk = 50 * numberOfCups
        println("$numberOfMilk ml of milk")
        val numberOfBeans = 15 * numberOfCups
        println("$numberOfBeans g of coffee beans")
    }
    //endregion

}

fun main() {
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.showResources()

}