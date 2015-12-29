package hello.dp.mediator

// Widgets
class ListBox {
  def getSelection: String = "selected"
  def click = ()
}

class EntryField {
  def setText(s: String) = println(s)
}

class DialogDirector {
  // Colleagues
  val listBox: ListBox = new ListBox with ListBoxDir
  val entryField: EntryField = new EntryField
  
  // Directing methods
  def showDialog = ()
  
  // called when listBox is clicked via advice
  def listBoxChanged = entryField.setText(listBox.getSelection)
  protected trait ListBoxDir extends ListBox {
    abstract override def click = {
      super.click
      listBoxChanged
    }
  }
}

object App {
  def main(args: Array[String]) {
    val dialog = new DialogDirector
    val listBox = dialog.listBox
    val entryField = dialog.entryField
    listBox.click
  }
}