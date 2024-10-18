package Lab5

import chisel3._
import chisel3.util._

class Adder(Width: Int) extends Module {
  require(Width >= 0)  
  val io = IO(new Bundle {
    val in0 = Input(UInt(Width.W))  
    val in1 = Input(UInt(Width.W))  
    val sum = Output(UInt(Width.W)) 
  })
  io.sum := io.in0 + io.in1
}


Test Bench:
import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}

class AdderTester(c: Adder) extends PeekPokeTester(c) {
  val testCases = Seq(
    (3.U, 5.U, 8.U),    
    (10.U, 15.U, 25.U), 
    (0.U, 0.U, 0.U),   
    (255.U, 1.U, 0.U)    //(overflow )
  )

  for ((in0, in1, expected) <- testCases) {
    poke(c.io.in0, in0)
    poke(c.io.in1, in1)
    step(1)
    expect(c.io.sum, expected)
  }
}

class AdderSpec extends ChiselFlatSpec {
  "Parameterized Adder" should "work correctly" in {
    Driver.execute(Array[String](), () => new Adder(8)) { c => new AdderTester(c)
    } should be(true)
  }
}
