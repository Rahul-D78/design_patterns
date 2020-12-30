package com.design.carpicker.vehicle.parts

class Chasis: Part {

   val seats: List<Seats> = listOf(
           Seats(), Seats()
   )
    override val price: Int
        get() = 200000
}