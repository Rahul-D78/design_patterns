package com.design.carpicker.vehicle.parts

class Transmission(val type: Type): Part {
    override val selfCost: Int
        get() = when(this.type) {
            Type.FWD -> 50000
            Type.AWD -> 100000
            Type.RWD -> 70000
        }
    override val totalCost = selfCost


    enum class Type{ FWD ,AWD, RWD}
}