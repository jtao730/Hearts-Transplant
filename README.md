# Hearts-Transplant
Simple java program that takes data in as a txt.file and creates an output or list of patients eligible for a "heart" transplant, as well as other sorting mechanisms. 
Objects: 
1. Person defines a person waiting for a heart transplant. 

2. SurvivabilityByAge defines the rate of survivability by age after a certain number of years after the transplant. 

3. SurvivabilityByCause defines the rate of survivability by heart condition cause after a certain number of years after the transplant. 

Functions listed below: 
readPersonsFromFile, readSurvivabilityRateByAgeFromFile, readSurvivabilityRateByCauseFromFile, getPatientsWithAgeAbovegetPatientsByStateOfHealth, getPatientsByHeartConditionCause, match. 

Match is function that receives as a parameter the number of available hearts for transplant and outputs all the recipients capable of receiving a heart ranked in order of survivability and need. 

Execute program using the following: 
java HeartTransplant < data.txt
The file data.txt is redirected as the input for the program HeartTransplant and can be read using the StdIn library functions StdIn.readInt() and StdIn.readDouble().
