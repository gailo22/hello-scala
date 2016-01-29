package hello.byexample

object QSort extends App {
  
  def sort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
          sort(xs filter (pivot >)),
               xs filter (pivot ==),
          sort(xs filter (pivot <)))
    }
  }
  
  sort(Array(4,3,5,1,2)) foreach println

}