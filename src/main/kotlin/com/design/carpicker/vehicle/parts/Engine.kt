package com.design.carpicker.vehicle.parts

class Engine: Part {

    val transmission: Transmission = Transmission()
    override val price: Int
        get() = 300000
}