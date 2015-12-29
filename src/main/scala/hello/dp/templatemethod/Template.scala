package hello.dp.templatemethod

trait Template extends (() => Int) {
  def subStepA
  def subStepB: Int
  
  def apply: Int = {
    subStepA
    subStepB
  }
  
}