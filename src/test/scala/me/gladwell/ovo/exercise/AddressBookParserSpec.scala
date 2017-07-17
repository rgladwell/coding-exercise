package me.gladwell.ovo.exercise

import org.scalatest._
import java.time._

class AddressBookParserSpec extends WordSpec with Matchers {

  "The AddressBookParser" should {

    val resource = getClass.getResourceAsStream("/AddressBook")
    val addressBook = AddressBookParser(resource)

    "read all contacts" in {
      addressBook.contacts.size shouldBe 5
    }

    "read contact name" in {
      addressBook.contacts.head.name shouldBe "Bill McKnight"
    }

    "read contact gender" in {
      addressBook.contacts.head.gender shouldBe "Male"
    }

    "read contact DOB" in {
      addressBook.contacts.head.dateOfBirth shouldBe LocalDate.of(1977, Month.MARCH, 16)
    }

  }

}
