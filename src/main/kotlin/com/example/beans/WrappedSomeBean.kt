package com.example.beans

/**
 * This is the work-around that was used to get the factory method to work.
 *
 * SomeBean's EachProperty annotation is somehow interfering with the factory method.  By creating a
 * trivial subclass of the bean, the factory method works.
 */
class WrappedSomeBean(name: String) : SomeBean(name)
