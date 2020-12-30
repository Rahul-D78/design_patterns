package com.design.carpicker.vehicle.parts

import com.design.carpicker.vehicle.parts.seat.Seat

class Chasis(
        val type: Type,
        val seatFactory: Seat.Factory): Part {

    val numSeats: Int = when(this.type){
        Type.HATCHBACK -> 4
        Type.SEDAN -> 5
        Type.SUV -> 8
        Type.PICKUP -> 2
    }

   val seats: List<Seat> = generateSequence { seatFactory.createSeat() }.take(numSeats).toList()
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