package com.design.carpicker.vehicle.parts

class Seats: Part {
    override val selfCost: Int
        get() = 15000
    override val totalCost = selfCost
}