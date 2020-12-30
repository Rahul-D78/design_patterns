package com.design.carpicker.vehicle.parts

class Chasis(val type: Type): Part {

   val seats: List<Seats> = listOf(
           Seats(), Seats()
   )
    override val selfCost: Int
        get() = when(this.type){
            Type.HATCHBACK -> 150000
            Type.SEDAN -> 160000
            Type.SUV -> 170000
            Type.PICKUP -> 140000
        }
    override val totalCost: Int
        get() = selfCost + seats.sumBy { it.totalCost }

    enum class Type { HATCHBACK, SEDAN, SUV, PICKUP }
}