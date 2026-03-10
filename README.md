# ShareRideAnthony

## Project Description
- Person 
    - Has all the initial information about a passenger (start + end destination, idNo, direction, etc)
    - Connects to the Car class
- Car
    - Has an ArrayList of passengers
    - Has simple functions including add and drop passenger
- Station
    - Has ArrayList of passengers arrived and waiting
    - Decided not to let the station keep track of car
- Road
    - Contains all the logic
        - Populates the station, car, and people
        - runRoad()
            - Contains helper methods 
                - Pick up and drop off potential passengers
                - Drop off all if car is full

## Simulation Results after 5,000 simulations:
20 cars: 57.544% of people make it to their final destination

40 cars: 79.6812% of people make it to their final destination

## Proud & struggles
I am proud of the logic of the entire program. I made it a lot more cleaner towards the end. 
I like my change of making all the other classes like Car, Person, and Station very simple while putting all the main logic on to the road. 

I struggled with having logic of having all the files connect with each other. Initially, my station was too complicated (accomplishing lots of what the road was doing), so it made it difficult to combine all the components together. 
