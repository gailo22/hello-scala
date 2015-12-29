package hello.dp.abstractfactory

abstract class Factory {
  type T1
  type T2
  
  def createA(f: () => T1)
  def createB(f: () => T2)
  
}