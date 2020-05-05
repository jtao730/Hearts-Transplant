# Hearts-Transplant
Simple java program that contains several functions in taking data in and outputting as patients eligible for a "heart" transplant. 
Contains a matching function that receives as a parameter the number of available hearts for transplant and will output all the recipients ranked in order of precedence.
Other functions: 
Person defines a person waiting for a heart transplant. T

SurvivabilityByAge defines the rate of survivability by age after a certain number of years after the transplant. 

SurvivabilityByCause defines the rate of survivability by heart condition cause after a certain number of years after the transplant. 
HeartTransplant is the driver of the heart transplant program.

Execute program using the following: 
java HeartTransplant < data.txt
The file data.txt is redirected as the input for the program HeartTransplant and can be read using the StdIn library functions StdIn.readInt() and StdIn.readDouble().
