package com.design.carpicker.vehicle

import com.design.carpicker.vehicle.parts.Engine
import com.design.carpicker.vehicle.parts.WheelBase

class Vehicle {

    val wheelBase: WheelBase = WheelBase()
    val engine: Engine = Engine()

    val price: Int get() {
        var costs = 0
        costs += wheelBase.price
        costs += wheelBase.chasis.price
        costs += engine.transmission.price
        costs += engine.price
        costs += wheelBase.wheel.sumBy { it.price }
        costs += wheelBase.chasis.seats.sumBy { it.price }
        return costs
    }
}