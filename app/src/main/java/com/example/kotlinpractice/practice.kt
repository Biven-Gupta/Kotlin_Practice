package com.example.kotlinpractice

import java.util.*

fun main() {
    // Class Car

    val mycar = Car()
    mycar.maxSpeed = 250
    println("Brand is ${mycar.brand}")
    println("Maximum Speed is ${mycar.maxSpeed}")

    var obj = Outer().Inner()
    obj.myFunc(5)
    // Class Person

    //var pooja = Person("Pooja", "Desai")
    val pooja = Person("Pooja", "Desai")
    pooja.apply {
        hobby = "Flying"
        firstName = "Pooja"
        lastName = "Desai"
        stateHobby()
    }
    val denis = Person("Denis", "Marshal")
    denis.hobby = "Coding"
    denis.stateHobby()
    var ajey = Person(firstName = "Ajey")
}

class Car {
    lateinit var owner: String
    var brand: String
        get() {
            return field.lowercase(Locale.ROOT)
        }

    init {
        "BMW".also { brand = it }
    }

    var maxSpeed: Int = 200
        get() = field
        set(value) {
            field =
                if (value > 0) value else throw IllegalArgumentException("\nMaximum Speed cannot be less than 0 \n" +
                        "Your MaxSpeed is $value")
        }


}


class Person(firstName: String = "Trainee", lastName: String = "Kapoor") {
    private var age: Int? = null
    var hobby: String? = "Cricket"

    // no need for init function
    var firstName: String? = null
    var lastName: String? = null

    init {
        this.firstName = firstName
        this.lastName = lastName
        println("Your Name is $firstName $lastName")
    }

    constructor(firstName: String, lastName: String, age: Int) : this(firstName, lastName) {
        this.age = age
        println("$firstName $lastName age is $age")
    }

    fun stateHobby() {
        println("$firstName $lastName\'s Hobby is $hobby")
    }

}


class Outer {
    private val rate: Double = 3.6
    fun display() {
        println(rate)
    }

    inner class Inner {
        fun myFunc(a: Int) {
            val a = 8
            println("Value of a is $a")
            display()
        }
    }
}