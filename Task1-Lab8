package lab8

import chisel3._
import chisel3.util._

class memory_assignment extends Module {
  val io = IO(new Bundle {
    val memory_out = Vec(4, Output(UInt(32.W)))
    val requestor = Vec(4, Flipped(Decoupled(UInt(32.W))))
    val Readaddr = Input(UInt(5.W))  
    val Writeaddr = Input(UInt(5.W)) 
  })

  val arbiter = Module(new Arbiter(UInt(32.W), 4))
  for (i<- 0 until  4) {
    arbiter.io.in(i)<>io.requestor(i)
  }
  val memoryBanks= VecInit(Seq.fill(4)(Mem(32, UInt(32.W))))


  for (i <- 0 until 4) {
   when(arbiter.io.chosen===i.U) {
   when (io.requestor(i).valid) { 
      memoryBanks(i).write(io.Writeaddr, arbiter.io.out)
    io.requestor(i).ready :=true.B 
          }
.otherwise{
                io.requestor(i).ready := false.B 
          }
      }
  }




    // Read from memory banks (always read – your design might be different)
    for (i <- 0 until 4) {
        io.memory_out(i) := memoryBanks(i).read(io.Readaddr)
    }




}
