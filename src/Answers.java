public class Answers {}
    /*
    In CarController handler uses gas brake
    it checks wheather the car reaches boundries
    stops and turns on car back again
    updates position using moveit()

    Solution: make a new class that controls collision and timer


        PRoblems: it has code that is uneccseary for this class the
only job it should have is to control car movement and nothing else
    it draws vehicel(paintComponent) and stores location.


    DrawPanel
    its job is to load volvo and saab but it can only do these two cars any
    only hardwired for these two car if we add another car the class needs to
        be adjusted for that car.
    Add a collection to store the vehicles and thier images.

    CarView
    its job is to display GUI but it also handles events handling this could be done
        separatly
    a seprate class should be made to control the event handling. */

