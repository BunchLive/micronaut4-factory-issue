## Example Project to Demonstrate Micronaut Injection Issue.

### Problem

A @Factory class which makes use of @EachBean is not properly applied to a bean which has an @EachProperty
annotation, which the @Factory is intended to replace.

The bean in question is a class within an external library which is annotated with @EachProperty.  To enable
configuration of this bean in a test environment, we were unable to configure the class in the standard way.
Instead, we created a @Factory class to create the bean using our own configuration sections, and intentionally do
not use the @EachProperty annotation on the bean class.

This functioned correctly when using Micronaut 3.x, but fails in Micronaut 4.x.

### Steps to Reproduce

This project contains a single test which demonstrates the issue.  

```sh
./gradlew test
```

This fails due to the bean not being found in the Micronaut context.


Classes used in this setup:
* `SomeBean` - The bean we are attempting to create with a @Factory, but which is already annotated with @EachProperty
* `SomeFactory` - The factory class which creates the bean - intended to be used instead of the bean's own @EachProperty annotation
* `SomeBeanConfig` - configuration class used in conjunction with the factory to create the bean
* `ServiceThing` - a simple @Context bean which uses the bean in question - used to force Micronaut to inject the bean.
* `WrappedSomeBeam` - a wrapper class which demonstrates a workaround for the issue
* `DemoTest` - simple test which verifies the Micronaut context.  The test fails because the bean is not found.

### Known Workaround

The issue appears to be a conflict between the @EachProperty annotation and the @Factory annotation.  Since the bean
in question is in an external library, we cannot remove the @EachProperty annotation.  However, we can create a trivial
subclass "wrapper" class which is *not* annotated with @EachProperty.  This wrapper class can then be injected
into the application in place of the original bean. 
