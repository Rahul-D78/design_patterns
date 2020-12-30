package com.design.carpicker.vehicle.parts

class WheelBase: Part {

    val wheel: List<Wheel> = listOf(
            Wheel(), Wheel(), Wheel(), Wheel()
    )
    val chasis: Chasis = Chasis()
    override val price: Int
        get() = 100000
}