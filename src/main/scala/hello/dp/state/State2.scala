package hello.dp.state

abstract class State_1(s: { def changeState(s: State_1) }) {
  def operation
}

class State1_1(s: { def changeState(s: State_1) }) extends State_1(s) {
  def operation = println(" State1_1 "); s.changeState(new State2_1(s))
}
class State2_1(s: { def changeState(s: State_1) }) extends State_1(s) {
  def operation = println(" State2_1 "); s.changeState(new State2_1(s))
}
