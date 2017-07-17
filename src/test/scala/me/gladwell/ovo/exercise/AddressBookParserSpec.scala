package me.gladwell.ovo.exercise

import org.scalatest._

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
  }

}
