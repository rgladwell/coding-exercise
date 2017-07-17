package me.gladwell.ovo.exercise

import java.io.InputStream
import com.github.tototoshi.csv._
import scala.io.Source

object AddressBookParser {

  def apply(is: InputStream): AddressBook = {
    val reader = CSVReader.open(Source.fromInputStream(is))

    val contacts =
      for {
        line <- reader.all()
      } yield Contact(name = line(0).trim, gender = line(1).trim)

    AddressBook(contacts)
  }

}
