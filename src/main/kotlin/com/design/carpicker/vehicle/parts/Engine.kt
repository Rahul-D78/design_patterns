package com.design.carpicker.vehicle.parts

class Engine(

        val type: Type,
        val transmission: Transmission
        ): Part {


    override val selfCost: Int
        get() = when(this.type){
            Type.PETROL -> 100000
            Type.DIESEL -> 200000
            Type.HYBRID -> 700000
            Type.ELECTRIC -> 500000
        }
    override val totalCost: Int
        get() = selfCost + transmission.totalCost

    enum class Type{ PETROL, DIESEL, HYBRID, ELECTRIC}
}