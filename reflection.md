Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
I decided to overload all of the constructors so there are default values. I felt like default values would make it easier to test code and for any user to see an example of a given class. I then created a new method 'enterNewRoom' in Building, and overloaded it in Cafe, House, and Library. Since there are rooms that require special instructions (like if it is a quiet room or if it is a bedroom) and sometimes people are only allowed in one room (like in a cafe), I thought overloading would be appropriate. 

- What worked, what didn't, what advice would you give someone taking this course in the future?
I reviewed the slides and they helped a lot for understanding overloading. I recommend trying different coding pathways to accomplish the same thing in order to see what works best / has less likelihood for errors. I did this with goToFloor() and whether the Building class or the House class contains hasElevator. I wanted to prepare for a library that did not have an elevator, so I added the constructor hasElevator to the Building class. 
