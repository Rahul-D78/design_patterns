package com.design.carpicker.vehicle.parts.wheel

import com.design.carpicker.vehicle.parts.Part

class Wheel private  constructor(val type: Type): Part {
    override val selfCost: Int
        get() = when(this.type) {
            Type.STEAL -> 10000
            Type.ALLOW -> 50000
            Type.CARBONFIBRE -> 100000
        }
    override val totalCost = selfCost

    enum class Type{ STEAL, ALLOW, CARBONFIBRE }

    class Factory(val type: Type){

        fun createWheel(): Wheel {
            return Wheel(type)
        }

    }

}