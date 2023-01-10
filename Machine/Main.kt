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
//    //Step 4
//fun main() {
//    //stage 4
//    var water = 400
//    var milk = 540
//    var beans = 120
//    var d_cups = 9
//    var money = 550
//
//    var _water = 250
//    var _milk = 0
//    var _beans = 16
//    var _cost = 4
//    val espresso = listOf(_water, _milk, _beans, _cost)
//
//    _water = 350
//    _milk = 75
//    _beans = 20
//    _cost = 7
//    val latte = listOf(_water, _milk, _beans, _cost)
//
//    _water = 200
//    _milk = 100
//    _beans = 12
//    _cost = 6
//
//    val cappuccino = listOf(_water, _milk, _beans, _cost)
//
//    fun buy() {
//        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: \n")
//        val buyWhat = readln()
//        val what: List<Int>
//        when (buyWhat) {
//            "1" -> what = espresso
//            "2" -> what = latte
//            "3" -> what = cappuccino
//            "back" -> return
//
//            else -> return
//        }
//        if (what[0] > water) {
//            println("Sorry, not enough water!")
//            return
//        }
//        if (what[1] > milk) {
//            println("Sorry, not enough milk!")
//            return
//        }
//
//        if (what[2] > beans) {
//            println("Sorry, not enough beans!")
//            return
//        }
//        if (d_cups == 0) {
//            println("Sorry, not enough cups!")
//            return
//        }
//        water -= what[0]
//        milk -= what[1]
//        beans -= what[2]
//        money += what[3]
//        d_cups--
////        println("I have enough resources, making you a coffee!")
//        println("The coffee machine has:")
//        println("$water ml of water")
//        println("$milk ml of milk")
//        println("$beans g of coffee beans")
//        println("$d_cups disposable cups" )
//        println("\$$money of money\n")
//
//    }
//
//    fun fill() {
//        println("Write how many ml of water you want to add:")
//        val w = readln().toInt()
//        print("Write how many ml of milk you want to add: \n")
//        val m = readln().toInt()
//        print("Write how many grams of coffee beans you want to add:\n")
//        val b = readln().toInt()
//        print("Write how many disposable cups you want to add:\n")
//        val c = readln().toInt()
//
//        water += w
//        milk += m
//        beans += b
//        d_cups += c
//
//        println("The coffee machine has:")
//        println("$water ml of water")
//        println("$milk ml of milk")
//        println("$beans g of coffee beans")
//        println("$d_cups disposable cups" )
//        println("\$$money of money\n")
//    }
//
//    fun take() {
//        println("I gave you \$$money \n")
//        money = 0
//        println("The coffee machine has:")
//        println("$water ml of water")
//        println("$milk ml of milk")
//        println("$beans g of coffee beans")
//        println("$d_cups disposable cups" )
//        println("\$$money of money")
//    }
//
//    println("The coffee machine has:")
//    println("$water ml of water")
//    println("$milk ml of milk")
//    println("$beans g of coffee beans")
//    println("$d_cups disposable cups" )
//    println("\$$money of money\n")
//    print("Write action (buy, fill, take): \n")
//    when (scanner.next()) {
//        "buy" -> buy()
//        "fill" -> fill()
//        "take" -> take()
//    }
//}
//    //endregion
//

//}
