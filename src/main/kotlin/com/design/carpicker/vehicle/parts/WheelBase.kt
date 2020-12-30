package com.design.carpicker.vehicle.parts

class WheelBase(
        val size: Size,
        val chasis: Chasis): Part {

    val wheel: List<Wheel> = listOf(
            Wheel(), Wheel(), Wheel(), Wheel()
    )
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