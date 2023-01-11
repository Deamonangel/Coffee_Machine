package machine

fun main() {
//stage 4
    var water = 400
    var milk = 540
    var beans = 120
    var d_cups = 9
    var money = 550

    var _water = 250
    var _milk = 0
    var _beans = 16
    var _cost = 4
    val espresso = listOf(_water, _milk, _beans, _cost)

    _water = 350
    _milk = 75
    _beans = 20
    _cost = 7
    val latte = listOf(_water, _milk, _beans, _cost)

    _water = 200
    _milk = 100
    _beans = 12
    _cost = 6

    val cappuccino = listOf(_water, _milk, _beans, _cost)

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: >")
        val buyWhat = readln()
        val what: List<Int>
        when (buyWhat) {
            "1" -> what = espresso
            "2" -> what = latte
            "3" -> what = cappuccino
            "back" -> return

            else -> return
        }
        if (what[0] > water) {
            println("Sorry, not enough water!")
            return
        }
        if (what[1] > milk) {
            println("Sorry, not enough milk!")
            return
        }

        if (what[2] > beans) {
            println("Sorry, not enough beans!")
            return
        }
        if (d_cups == 0) {
            println("Sorry, not enough cups!")
            return
        }
        water -= what[0]
        milk -= what[1]
        beans -= what[2]
        money += what[3]
        d_cups--
        println("I have enough resources, making you a coffee!")

    }

    fun fill() {
        print("water ? ")
        val w = readln().toInt()
        print("milk ? ")
        val m = readln().toInt()
        print("beans ? ")
        val b = readln().toInt()
        print("cups ? ")
        val c = readln().toInt()

        water += w
        milk += m
        beans += b
//        money += what[3]
        d_cups += c


    }

    fun remaining() {
        println(
            "The coffee machine has:\n" +
                    "$water ml of water\n" +
                    "$milk ml of milk\n" +
                    "$beans g of coffee beans\n" +
                    "$d_cups disposable cups\n" +
                    "\$$money of money"
        )
    }

    fun take() {
        println("I gave you \$$money")
        money = 0
    }


    var command = ""
    while (command != "exit") {
        println("Write action (buy, fill, take, remaining, exit): >")
        command = readln()
        when (command) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
        }
    }
}
