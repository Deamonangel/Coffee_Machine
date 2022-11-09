package Machine


class CoffeeMachine(
    var water: Int = 200,
    var milk: Int = 50,
    var coffeeBeans: Int = 15,
    var cups: Int = 1,
) {

    fun showResources() {
        println("Write how many ml of water the coffee machine has:")
        water = readln().toInt()
        println("Write how many ml of milk the coffee machine has:")
        milk = readln().toInt()
        println("Write how many grams of coffee beans the coffee machine has:")
        coffeeBeans = readln().toInt()
        println("Write how many cups of coffee you will need:")
        cups = readln().toInt()

        val maxCups = minOf((water/200), (milk/50), (coffeeBeans/15))

        when {
            maxCups > cups -> println("Yes, I can make that amount of coffee (and even ${maxCups - cups} more than that)")
            maxCups < cups -> println("No, I can make only $maxCups cups of coffee")
            else -> println("Yes, I can make that amount of coffee")
        }
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

    private fun printStatsStep3(){
        println("Write how many ml of water the coffee machine has:")
        water = readln().toInt()
        println("Write how many ml of milk the coffee machine has:")
        milk = readln().toInt()
        println("Write how many grams of coffee beans the coffee machine has:")
        coffeeBeans = readln().toInt()
        println("Write how many cups of coffee you will need:")
        cups = readln().toInt()

        val maxCups = minOf((water/200), (milk/50), (coffeeBeans/15))

        when {
            maxCups > cups -> println("Yes, I can make that amount of coffee (and even ${maxCups - cups} more than that)")
            maxCups < cups -> println("No, I can make only $maxCups cups of coffee")
            else -> println("Yes, I can make that amount of coffee")
        }

    }
    //endregion

}



fun main() {
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.showResources()

}
