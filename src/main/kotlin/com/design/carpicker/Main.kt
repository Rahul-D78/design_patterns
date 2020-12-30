package com.design.carpicker

import com.design.carpicker.vehicle.Vehicle
import com.design.carpicker.vehicle.parts.Chasis
import com.design.carpicker.vehicle.parts.Engine
import com.design.carpicker.vehicle.parts.Transmission
import com.design.carpicker.vehicle.parts.WheelBase

fun main(args: Array<String>) {
    println("Hello")

    val hondaCity = Vehicle(
            WheelBase(
                    WheelBase.Size.MEDIUM,
                    Chasis(Chasis.Type.SEDAN)
            ),
            Engine(
                    Engine.Type.DIESEL,
                    Transmission(Transmission.Type.FWD)
            ))
    val audi = Vehicle(
            WheelBase(
                    WheelBase.Size.LARGE,
                    Chasis(Chasis.Type.SUV)
            ),
            Engine(
                    Engine.Type.HYBRID,
                    Transmission(Transmission.Type.AWD)
            ))

    println("cost of my vehicle is ${audi.price}")
    println("cost of my vehicle is ${hondaCity.price}")
}