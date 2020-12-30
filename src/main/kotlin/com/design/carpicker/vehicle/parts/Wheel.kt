package com.design.carpicker.vehicle.parts

class Wheel: Part {
    override val selfCost: Int
        get() = 15000
    override val totalCost = selfCost
}