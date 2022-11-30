package machine

import java.util.*

val scanner = Scanner(System.`in`)

val coffeeMachine = CoffeeMachine()

fun main() {
    print("Write action (buy, fill, take, remaining, exit): ")
    when (scanner.next()) {
        "remaining" -> println("\n${coffeeMachine.state()}\n")
        "buy" -> {
            print("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
            val input = scanner.next()
            when (input) {
                "back" -> { println(); return main() }
                "1", "2", "3" -> println ("${coffeeMachine.buy(input.toInt())}\n")
            }
        }
        "fill" -> {
            print("Write how many ml of water do you want to add: ")
            val water = scanner.nextInt()
            print("Write how many ml of milk do you want to add: ")
            val milk = scanner.nextInt()
            print("Write how many grams of coffee beans do you want to add: ")
            val coffee = scanner.nextInt()
            print("Write how many disposable cups of coffee do you want to add: ")
            val dispcups = scanner.nextInt()
            coffeeMachine.fill(water, milk, coffee, dispcups)
            println()
        }
        "take" -> {
            println("\nI gave you $${coffeeMachine.take()}\n")
        }
        "exit" -> return
    }
    main()
}

class CoffeeMachine(
    private var water: Int = 400,
    private var milk: Int = 540,
    private var coffee: Int = 120,
    private var dispcups: Int = 9,
    private var money: Int = 550) {

    fun state() = """The coffee machine has:
        |$water of water
        |$milk of milk
        |$coffee of coffee beans
        |$dispcups of disposable cups
        |$money of money""".trimMargin()

    fun buy(variety: Int): String {
        val _water: Int
        val _milk: Int
        val _coffee: Int
        val _money: Int

        when (variety) {
            1 -> { _water = 250; _milk = 0; _coffee = 16; _money = 4 }
            2 -> { _water = 350; _milk = 75; _coffee = 20; _money = 7 }
            3 -> { _water = 200; _milk = 100; _coffee = 12; _money = 6 }
            else -> { _water = 0; _milk = 0; _coffee = 0; _money = 0 }
        }

        fun outOf(res: String) = "Sorry, not enough $res!"

        return when {
            water - _water < 0 -> outOf("water")
            milk - _milk < 0 -> outOf("milk")
            coffee - _coffee < 0 -> outOf("coffee beans")
            dispcups - 1 < 0 -> "Sorry, I'm out of disposable cups!"
            else -> {
                water -= _water
                milk -= _milk
                coffee -= _coffee
                dispcups -= 1
                money += _money
                "I have enough resources, making you a coffee!"
            }
        }
    }

    fun fill(_water: Int, _milk: Int, _coffee: Int, _dispcups: Int) {
        water += _water
        milk += _milk
        coffee += _coffee
        dispcups += _dispcups
    }

    fun take(): Int {
        val buffer = money
        money = 0
        return buffer
    }
}


//    //region Step
//    //Starting Point
//    private fun printStatsStep0() {
//        fun main() {
//            println("Hello, world!")
//            println("Starting to make a coffee")
//            println("Grinding coffee beans")
//            println("Boiling water")
//            println("Mixing boiled water with crushed coffee beans")
//            println("Pouring coffee into the cup")
//            println("Pouring some milk into the cup")
//            println("Coffee is ready!")
//        }
//    }
//
//    //Step 1
//    private fun printStatsStep1() {
//        println("Write how many ml of water do you want to add: ")
//        val numberOfCups = readln().toInt()
//        println("For $numberOfCups  cups of coffee you will need:")
//        val numberOfWater = 1000 * numberOfCups
//        println("$numberOfWater ml of water")
//        val numberOfMilk = 50 * numberOfCups
//        println("$numberOfMilk ml of milk")
//        val numberOfBeans = 15 * numberOfCups
//        println("$numberOfBeans g of coffee beans")
//    }
//
//    //Step 2
//    private fun printStatsStep2() {
//        println()
//        println("Write how many ml of water do you want to add: ")
//        val numberOfCups = readln().toInt()
//        println("For $numberOfCups  cups of coffee you will need:")
//        val numberOfWater = 200 * numberOfCups
//        println("Write how many ml of milk the coffee machine has:")
//        val numberOfMilk = 50 * numberOfCups
//        println("$numberOfMilk ml of milk")
//        val numberOfBeans = 15 * numberOfCups
//        println("$numberOfBeans g of coffee beans")
//    }
//    //Step 3
//class CoffeeMachine(
//    var water: Int = 200,
//    var milk: Int = 50,
//    var coffeeBeans: Int = 15,
//    var cups: Int = 1,
//) {
//
//    fun showResources() {
//        println("Write how many ml of water the coffee machine has:")
//        water = readln().toInt()
//        println("Write how many ml of milk the coffee machine has:")
//        milk = readln().toInt()
//        println("Write how many grams of coffee beans the coffee machine has:")
//        coffeeBeans = readln().toInt()
//        println("Write how many cups of coffee you will need:")
//        cups = readln().toInt()
//
//        val maxCups = minOf((water / 200), (milk / 50), (coffeeBeans / 15))
//
//        when {
//            maxCups > cups -> println("Yes, I can make that amount of coffee (and even ${maxCups - cups} more than that)")
//            maxCups < cups -> println("No, I can make only $maxCups cups of coffee")
//            else -> println("Yes, I can make that amount of coffee")
//        }
//    }
//}
//fun main() {
//    val coffeeMachine = CoffeeMachine()
//    coffeeMachine.showResources()
//
//}
//
//    //endregion
//

//}
