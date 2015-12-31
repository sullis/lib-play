package io.flow.play.util

/**
  * Wrapper on the scala random libraries providing higher level
  * common functions.
  */
case class Random() {

  private[this] val random = new scala.util.Random

  private[this] val Lower = "abcdefghijklmnopqrstuvwxyz"
  private[this] val LowerAndUpper = Lower + Lower.toUpperCase
  private[this] val LowerAndUpperAndNumbers = LowerAndUpper + "0123456789"
  private[this] val Ambiguous = "B8G6I1l0OQDS5Z2"
  private[this] val NonAmbiguousLowerAndUpperAndNumbers = LowerAndUpperAndNumbers.split("").filter ( l =>
    !Ambiguous.split("").contains(l)
  ).mkString("")

  /**
    * Generate a random string of length n from the given alphabet
    * 
    * @param alphabet The complete set of 
    * @param n Length of random string to generate
    */
  def string(alphabet: String)(n: Int): String = {
    assert(n > 0, "n must be > 0")
    Stream.continually(random.nextInt(alphabet.size)).map(alphabet).take(n).mkString
  }

  /**
    * Generate a random string of length n using only a-z (lower case
    * alphabet letters)
    * 
    * @param n Length of random string to generate
    */
  def lowercaseAlpha(n: Int) = {
    string(Lower)(n)
  }

  /**
    * Generate a random string of length n using only a-z and A-Z
    * (alphabet letters only)
    * 
    * @param n Length of random string to generate
    */
  def alpha(n: Int) = {
    string(LowerAndUpper)(n)
  }

  /**
    * Generate a random string of length n using only letters (a-z,
    * A-Z) and numbers (0-9). Also guarantees that the random string
    * will start with a letter, not a number - this is mostly to
    * prevent problems with any applications that infer numeric based
    * on first digit (or strip zeroes).
    * 
    * @param n Length of random string to generate
    */
  def alphaNumeric(n: Int) = {
    alpha(1) + string(LowerAndUpperAndNumbers)(n - 1)
  }

    /**
    * Generate a random string of length n using only letters and
    * numbers that are non ambiguous (e.g. B can look like an 8 so
    * neither B nor 8 is used in the random string). This is a good
    * option for random strings that will be read by humans.
    * 
    * @param n Length of random string to generate
    */
  def alphaNumericNonAmbiguous(n: Int) = {
    alpha(1) + string(LowerAndUpperAndNumbers)(n - 1)
  }

  /**
    * Generate a random positive int
    */
  @scala.annotation.tailrec
  final def positiveInt(): Int = {
    val value = random.nextInt
    (value > 0) match {
      case true => value
      case false => positiveInt()
    }
  }

  /**
    * Generate a random positive long
    */
  @scala.annotation.tailrec
  final def positiveLong(): Long = {
    val value = random.nextLong
    (value > 0) match {
      case true => value
      case false => positiveLong()
    }
  }

}
