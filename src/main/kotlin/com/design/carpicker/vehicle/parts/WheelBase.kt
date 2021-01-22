package com.design.carpicker.vehicle.parts

import com.design.carpicker.vehicle.parts.wheel.Wheel

class WheelBase private constructor(
        val size: Size,
        val chasis: Chasis,
        val wheels: List<Wheel>,
        ): Part {


    override val selfCost: Int
        get() = when(this.size) {
            Size.SMALL -> 100000
            Size.MEDIUM -> 125000
            Size.LARGE -> 175000 
        }
    override val totalCost: Int
        get() = chasis.totalCost + wheels.sumBy { it.totalCost }


    enum class Size { SMALL, MEDIUM, LARGE}

    class Builder {

        private lateinit var size: WheelBase.Size
        private lateinit var chasis: Chasis
        private lateinit var wheelFactory: Wheel.Factory
        private var spearWheel: Boolean = false

        fun setSize(size: Size): Builder {
            this.size = size
            return this
        }

        fun setChasis(chasis: Chasis): Builder {
            this.chasis = chasis
            return this
        }

        fun setWheelFactory(wheelFactory: Wheel.Factory): Builder {
            this.wheelFactory = wheelFactory
            return this
        }

        fun setSpearWheel(spearWheel: Boolean): Builder {
            this.spearWheel = spearWheel
            return this
        }

        fun build(): WheelBase{
            return WheelBase(
                    this.size,
                    this.chasis,
                    this.wheelFactory.createWheels(
                            4 + if(this.spearWheel) 1 else 0
                    ),
            )
        }
    }
}