package com.design.carpicker.vehicle.parts

import com.design.carpicker.vehicle.parts.seat.Seat
import javax.sql.rowset.RowSetFactory

class Chasis private constructor(
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

    class Builder{

        lateinit var chasisType: Chasis.Type
        lateinit var seatFactory: Seat.Factory

        fun setChasisType(chasisType: Chasis.Type): Builder {
            this.chasisType = chasisType
            return this
        }

        fun setSeatFactory(seatFactory: Seat.Factory): Builder {
            this.seatFactory = seatFactory
            return this
        }

        fun build(): Chasis{
            return Chasis(this.chasisType, this.seatFactory)
        }
    }
}