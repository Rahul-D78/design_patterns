package com.design.carpicker

import com.design.carpicker.vehicle.Vehicle
import com.design.carpicker.vehicle.parts.Chasis
import com.design.carpicker.vehicle.parts.Engine
import com.design.carpicker.vehicle.parts.Transmission
import com.design.carpicker.vehicle.parts.WheelBase
import com.design.carpicker.vehicle.parts.seat.Seat
import com.design.carpicker.vehicle.parts.wheel.Wheel
import com.github.ajalt.clikt.core.UsageError
import com.github.ajalt.clikt.output.TermUi

fun main(args: Array<String>) {

    println("""
        Welcome to car picker 
        Type [y] to go to the customize section 
     """.trimIndent())

    if(TermUi.confirm("Continue to Build the car ?") != true) {
        return
    }

    val selectedWheelbase:WheelBase.Size = TermUi.prompt(
            "Enter WheelBase Size (S)mall (M)edium or (L)arge"
    ){when (it) {
        "S", "s" -> WheelBase.Size.SMALL
        "M", "m" -> WheelBase.Size.MEDIUM
        "L", "l" -> WheelBase.Size.LARGE
        else -> throw UsageError("Size has to be s , m or l")
    } }!!

    val selectedChasis:Chasis.Type = TermUi.prompt(
            "Enter Type Of chasis (H)actchback (S)edan (P)ickup (suv)SUV"
    ){when (it) {
      "H" ,"h" -> Chasis.Type.HATCHBACK
      "suv","SUV" -> Chasis.Type.SUV
      "S", "s" -> Chasis.Type.SEDAN
      "P", "p" -> Chasis.Type.PICKUP
      else -> throw UsageError("Type has to be s, p, h or suv")
    } }!!

    val selectedSeat:Seat.Upholstery = TermUi.prompt(
            "Enter Type Of Seat (L)eather (R)exine (C)loth "
    ){when (it) {
        "C" ,"c" -> Seat.Upholstery.CLOTH
        "r","R" -> Seat.Upholstery.REXINE
        "L", "l" -> Seat.Upholstery.LEATHER
        else -> throw UsageError("Type has to be c, r or l")
    } }!!

    val selectedWheel: Wheel.Type = TermUi.prompt(
            "Enter Type Of Wheel (A)llow (S)teal (C)arbonfiber "
    ){when (it) {
        "A" ,"a" -> Wheel.Type.ALLOW
        "C","c" -> Wheel.Type.CARBONFIBRE
        "S", "s" -> Wheel.Type.STEAL
        else -> throw UsageError("Type has to be a, s, c")
    } }!!

    val selectedEngine:Engine.Type = TermUi.prompt(
            "Enter Type Of Engine [H | E | D | P]"
    ){when (it) {
        "H" ,"h" -> Engine.Type.HYBRID
        "E","e" -> Engine.Type.ELECTRIC
        "D", "d" -> Engine.Type.DIESEL
        "P", "p" -> Engine.Type.PETROL
        else -> throw UsageError("Type has to be e, d, p or hybrid")
    } }!!

    val selectedTransmission:Transmission.Type = TermUi.prompt(
            "Enter Type Of Transmission [A | F | R]"
    ){when (it) {
        "A" ,"a" -> Transmission.Type.AWD
        "R","r" ->  Transmission.Type.RWD
        "F", "F" -> Transmission.Type.FWD
        else -> throw UsageError("Type has to be a, r or f")
    } }!!


    val audi = Vehicle(
            WheelBase(
                    selectedWheelbase,
                    Chasis(selectedChasis,
                    Seat.Factory(selectedSeat)),
                    Wheel.Factory(selectedWheel),
                    spearWheel = true
            ),
            Engine(
                    selectedEngine,
                    Transmission(selectedTransmission)
            ))

    println("cost of my vehicle is ${audi.price}")
}