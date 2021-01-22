package com.design.carpicker.vehicle.parts.seat

import com.design.carpicker.vehicle.parts.Part

class Seat private constructor(
        val upholstery: Upholstery
        ): Part {

    override val selfCost: Int
        get() = when(this.upholstery){
            Upholstery.CLOTH -> 15000
            Upholstery.REXINE -> 25000
            Upholstery.LEATHER -> 50000
        }
    override val totalCost = selfCost

    enum class Upholstery {CLOTH , REXINE ,LEATHER}

    class Factory (val upholstery: Upholstery) {
        fun createSeats(numOfSeats: Int): List<Seat>{
           return generateSequence { Seat(upholstery) }.take(numOfSeats).toList()
        }
    }
}