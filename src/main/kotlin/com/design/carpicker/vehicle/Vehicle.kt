package com.design.carpicker.vehicle

import com.design.carpicker.vehicle.parts.Engine
import com.design.carpicker.vehicle.parts.WheelBase

class Vehicle(
        val wheelBase: WheelBase,
        val engine: Engine) {


    val price = (wheelBase.totalCost + engine.totalCost)
}