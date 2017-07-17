package me.gladwell.ovo.exercise

import java.io.InputStream
import com.github.tototoshi.csv._
import scala.io.Source
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.time.Year

object AddressBookParser {

  private val formatter =
    new DateTimeFormatterBuilder().appendPattern("dd/MM/")
      .appendValueReduced(
        ChronoField.YEAR, 2, 2, Year.now().getValue() - 100
      ).toFormatter();

  def apply(is: InputStream): AddressBook = {
    val reader = CSVReader.open(Source.fromInputStream(is))

    val contacts =
      for {
        line <- reader.all()
      } yield
        Contact(
          name = line(0).trim,
          gender = line(1).trim,
          dateOfBirth = LocalDate.parse(line(2).trim, formatter)
        )

    AddressBook(contacts)
  }

}
