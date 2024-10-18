package Lab2

import chisel3._
import chisel3.util._

class barrel_shift extends Module {
  val io = IO(new Bundle {
    val in = Vec(4, Input(Bool()))
    val sel = Vec(2, Input(Bool()))  // Selection lines
    val shift_type = Input(Bool())   // Shift type: 0 for logical, 1 for arithmetic
    val out = Vec(4, Output(Bool())) // 4-bit output
  })

  val mux = Wire(Vec(4, Bool()))
  when(io.shift_type === false.B) {
    mux(0) := MuxLookup(Cat(io.sel(1), io.sel(0)), io.in(0), Array(
      "b00".U -> io.in(0),
      "b01".U -> io.in(1),
      "b10".U -> io.in(2),
      "b11".U -> io.in(3)
    ))
    mux(1) := MuxLookup(Cat(io.sel(1), io.sel(0)), io.in(1), Array(
      "b00".U -> io.in(0),
      "b01".U -> io.in(1),
      "b10".U -> io.in(2),
      "b11".U -> io.in(3)
    ))
    mux(2) := MuxLookup(Cat(io.sel(1), io.sel(0)), io.in(2), Array(
      "b00".U -> io.in(0),
      "b01".U -> io.in(1),
      "b10".U -> io.in(2),
      "b11".U -> io.in(3)
    ))
    mux(3) := MuxLookup(Cat(io.sel(1), io.sel(0)), io.in(3), Array(
      "b00".U -> io.in(0),
      "b01".U -> io.in(1),
      "b10".U -> io.in(2),
      "b11".U -> io.in(3)
    ))
  }.otherwise {
    mux(0) := MuxLookup(Cat(io.sel(1), io.sel(0)), io.in(0), Array(
      "b00".U -> io.in(0),
      "b01".U -> io.in(1),
      "b10".U -> io.in(2),
      "b11".U -> io.in(3)
    ))
    mux(1) := MuxLookup(Cat(io.sel(1), io.sel(0)), io.in(1), Array(
      "b00".U -> io.in(0),
      "b01".U -> io.in(1),
      "b10".U -> io.in(2),
      "b11".U -> io.in(3)
    ))
    mux(2) := MuxLookup(Cat(io.sel(1), io.sel(0)), io.in(2), Array(
      "b00".U -> io.in(0),
      "b01".U -> io.in(1),
      "b10".U -> io.in(2),
      "b11".U -> io.in(3)
    ))
    mux(3) := MuxLookup(Cat(io.sel(1), io.sel(0)), io.in(3), Array(
      "b00".U -> io.in(0),
      "b01".U -> io.in(1),
      "b10".U -> io.in(2),
      "b11".U -> io.in(3)
    ))
  }
  io.out := mux
  
}

println((new chisel3.stage.ChiselStage).emitVerilog(new barrel_shift))
