package ASSIGN2.task_1

//Exercise 1: Design an FSM by using a companion object. Put static functionality in companion object i.e. enum will be placed inside the object instead of class then use this to develop your FSM code inside the class.
class Ex_5 {
  private var currentState: Ex_5.State.Value = Ex_5.State.Idle

  def getCurrentState: Ex_5.State.Value = currentState

  def transition(event: String): Unit = {
    currentState = (currentState, event) match {
      case (Ex_5.State.Idle, "login")      => Ex_5.State.Completed
      case (Ex_5.State.Completed, "read data") => Ex_5.State.Processing
      case (Ex_5.State.Processing, "logout") => Ex_5.State.Idle
      case (Ex_5.State.Completed, "logout") => Ex_5.State.Idle
      case _ => currentState
    }
  }
}

object Ex_5 {
  object State extends Enumeration {
    type State = Value
    val Idle, Completed, Processing = Value
  }
}

  object Main extends App {
    val fsm = new Ex_5

    println(s"Current State: ${fsm.getCurrentState}")

    fsm.transition("login")
    println(s"After 'login' event: ${fsm.getCurrentState}")

    fsm.transition("read data")
    println(s"After 'read data' event: ${fsm.getCurrentState}")

    fsm.transition("logout")
    println(s"After 'logout' event: ${fsm.getCurrentState}")
  }
