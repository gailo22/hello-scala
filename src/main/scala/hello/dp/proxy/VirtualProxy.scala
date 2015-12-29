package hello.dp.proxy

class VirtualProxy {
  lazy val expensiveOperation = List(1 to 1000000000)
}