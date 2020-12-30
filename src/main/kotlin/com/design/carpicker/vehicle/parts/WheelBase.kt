package com.design.carpicker.vehicle.parts

import com.design.carpicker.vehicle.parts.wheel.Wheel

class WheelBase(
        val size: Size,
        val chasis: Chasis,
        val wheelFactory: Wheel.Factory,
        val spearWheel: Boolean  = false
        ): Part {

    val numOfWheels: Int = 4 + (if(spearWheel) 1 else 0)

    val wheel: List<Wheel> = generateSequence { wheelFactory.createWheel() }.take(numOfWheels).toList()

    override val selfCost: Int
        get() = when(this.size) {
            Size.SMALL -> 100000
            Size.MEDIUM -> 125000
            Size.LARGE -> 175000 
        }
    override val totalCost: Int
        get() = chasis.totalCost + wheel.sumBy { it.totalCost }


    enum class Size { SMALL, MEDIUM, LARGE}
}