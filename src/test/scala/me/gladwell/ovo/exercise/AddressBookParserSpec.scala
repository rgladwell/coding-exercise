package me.gladwell.ovo.exercise

import org.scalatest._

class AddressBookParserSpec extends WordSpec with Matchers {

  "The AddressBookParser" should {

    val resource = getClass.getResourceAsStream("/AddressBook")
    val addressBook = AddressBookParser(resource)

    "read all contacts" in {
      addressBook.contacts.size shouldBe 5
    }

  }

}
