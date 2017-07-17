package me.gladwell.ovo.exercise

import java.io.InputStream
import com.github.tototoshi.csv._
import scala.io.Source

object AddressBookParser {

  def apply(is: InputStream): AddressBook = {
    val reader = CSVReader.open(Source.fromInputStream(is))

    val items =
      for {
        line <- reader.all()
      } yield Item()

    AddressBook(items)
  }

}
