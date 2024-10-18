package Counter

import chisel3._
class CounterUpDown(n: Int) extends Module {
  val io = IO(new Bundle {
    val reload = Input(Bool())
    val out = Output(Bool())
  })
  val counter = RegInit(0.U(n.W))
  val up = RegInit(true.B)
  val max_count = 6.U
  io.out := false.B
  when(io.reload) {
    counter := 0.U
    up := true.B
  }.elsewhen(up) {
    when(counter === max_count) {
      io.out := true.B
      up := false.B
    }.otherwise { counter := counter + 1.U }
  }.otherwise {
    when(counter === 0.U) {
      io.out := true.B
      up := true.B
    }.otherwise { counter := counter - 1.U }
  }
}
