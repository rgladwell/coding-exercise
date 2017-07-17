package me.gladwell.ovo.exercise

import org.scalatest._

class AddressBookParserSpec extends WordSpec with Matchers {

  "The AddressBookParser" should {

    val resource = getClass.getResourceAsStream("/AddressBook")
    val addressBook = AddressBookParser(resource)

    "read all entries" in {
      addressBook.items.size shouldBe 5
    }

  }

}
