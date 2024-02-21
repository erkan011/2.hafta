fun main() {
    println("Welcome to Simple Mathematical Operation Application!")

    val scanner = Scanner(System.`in`)
    var continueCalculation = true

    while (continueCalculation) {
        println("Enter the first number:")
        val firstNumber = getUserInput(scanner)

        println("Choose the mathematical operation you want to perform (+, -, *, /):")
        val operator = getOperator(scanner)

        println("Enter the second number:")
        val secondNumber = getUserInput(scanner)

        try {
            val result = calculate(firstNumber, secondNumber, operator)
            println("Result: $result")
        } catch (e: ArithmeticException) {
            println("Error: ${e.message}")
        }

        println("Do you want to continue? (Enter 'y' or 'Y' for Yes):")
        val continueInput = scanner.next()
        continueCalculation = continueInput.equals("y", ignoreCase = true)
    }

    println("Application terminated. Have a nice day!")
}

fun getUserInput(scanner: Scanner): Double {
    while (true) {
        try {
            return scanner.nextDouble()
        } catch (e: InputMismatchException) {
            println("Error: Please enter a number.")
            scanner.next() // clear buffer
        }
    }
}

fun getOperator(scanner: Scanner): Char {
    while (true) {
        val input = scanner.next()
        if (input.length == 1 && "+-*/".contains(input)) {
            return input[0]
        } else {
            println("Error: Invalid operation operator. Try again.")
        }
    }
}

fun calculate(firstNumber: Double, secondNumber: Double, operator: Char): Double {
    return when (operator) {
        '+' -> firstNumber + secondNumber
        '-' -> firstNumber - secondNumber
        '*' -> firstNumber * secondNumber
        '/' -> {
            if (secondNumber == 0.0) {
                throw ArithmeticException("Division by zero error!")
            } else {
                firstNumber / secondNumber
            }
        }
        else -> throw IllegalArgumentException("Invalid operation operator.")
    }
}
