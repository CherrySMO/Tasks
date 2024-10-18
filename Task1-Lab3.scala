// Branch control (Assignment)
package lab3

import chisel3._
import chisel3.util._

class LM_IO_Interface_BranchControl extends Bundle {
  val fnct3 = Input(UInt(3.W))      
  val arg_x = Input(UInt(32.W))     
  val arg_y = Input(UInt(32.W))     
  val br_taken = Output(Bool())        
}

class BranchControl extends Module {
  val io = IO(new LM_IO_Interface_BranchControl)
  io.br_taken := false.B

  switch(io.fnct3) {
    is("b000".U) {
      io.br_taken := (io.arg_x === io.arg_y)
    }
    is("b001".U) { 
      io.br_taken := (io.arg_x =/= io.arg_y)
    }
    is("b100".U) { 
      io.br_taken := (io.arg_x.asSInt() < io.arg_y.asSInt())
    }
    is("b101".U) {
      io.br_taken := (io.arg_x.asSInt() >= io.arg_y.asSInt())
    }
    is("b110".U) { 
      io.br_taken := (io.arg_x < io.arg_y)
    }
    is("b111".U) { 
      io.br_taken := (io.arg_x >= io.arg_y)
    }
  }
}

println((new chisel3.stage.ChiselStage).emitVerilog(new BranchControl))
