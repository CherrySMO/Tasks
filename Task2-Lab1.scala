package Lab2

import chisel3._
class LM_IO_Interface extends Bundle {
  val s0 = Input(Bool())
  val s1 = Input(Bool())
  val s2 = Input(Bool())
  val out = Output(UInt(32.W))
}

class Mux_5to1 extends Module {
  val io = IO(new LM_IO_Interface)
  io.out := 0.U 

  switch(Cat(io.s2, io.s1, io.s0)) {
    is("b000".U) { io.out := 0.U }
    is("b001".U) { io.out := 8.U }
    is("b010".U) { io.out := 16.U }
    is("b011".U) { io.out := 24.U }
    is("b1xx".U) { io.out := 32.U }
  }
}
println((new chisel3.stage.ChiselStage).emitVerilog(new Mux_5to1))
