# Android Dagger2 with Subcomponents approach

This project shows that the class with the @Singleton annotation lasts the entire lifecycle of the application, but what if we need it only once?

Components that do not need to remain in memory all the time (i.e. components that are tied to the lifecycle of an activity or fragment, or even tied to when a user is signed-in) are the dependent components or subcomponents.

This project consists of one subcomponent and a parent component.

For instance, if we wish to use a component created for the entire activity lifecycle, we can define our own @ActivityScope interface.

![dagger2 subcomponents](https://github.com/Semeruk/Android-Dagger2-Subcomponents/blob/master/diagram_subcomponents.jpg)
