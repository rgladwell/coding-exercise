package me.gladwell.ovo.exercise

import org.scalatest._

class OvoTestSpec extends WordSpec with Matchers {

  val resource = getClass.getResourceAsStream("/AddressBook")
  val addressBook = AddressBookParser(resource)

  "There should be 3 males in the address book" in {
    addressBook.contacts.count{ _.gender == "Male" } shouldBe 3
  }

  "Wes Jackson is the oldest person in the address book" in {
    addressBook.contacts.min(Ordering.by{ (c: Contact) => c.dateOfBirth.toEpochDay }).name shouldBe "Wes Jackson"
  }

  "Bill is 2862 days older than Paul" in {
    val bill = addressBook.contacts.find{ _.name == "Bill McKnight" }.getOrElse(sys.error("could not find Bill"))
    val paul = addressBook.contacts.find{ _.name == "Paul Robinson" }.getOrElse(sys.error("could not find Paul"))

    Math.abs(bill.dateOfBirth.toEpochDay - paul.dateOfBirth.toEpochDay) shouldBe 2862
  }

}
