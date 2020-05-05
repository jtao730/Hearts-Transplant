/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author:
 *
 *************************************************************************/

public class HeartTransplant {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    /* ------ Constructor  -------- */
    
    /*
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {
        listOfPatients = null;
        survivabilityByAge = null;
        survivabilityByCause = null;
        // WRITE YOUR CODE HERE
    }

    /* ------ Methods  -------- */

    /*
     * Inserts Person p into listOfPatients
     * 
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) {
        try
        {
            listOfPatients[arrayIndex] = p;
            return 0;
        }
        catch(Exception exception)
        {
            return -1; 
        }
    }
    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {

        // WRITE YOUR CODE HERE
        listOfPatients = new Person[numberOfLines];
        int id;
        int ethnicity; 
        int gender; 
        int age; 
        for (int i = 0; i<numberOfLines; i++)
        {
            id = StdIn.readInt();
            ethnicity = StdIn.readInt(); 
            gender = StdIn.readInt();
            age = StdIn.readInt(); 
            int cause = StdIn.readInt(); 
            int urgency = StdIn.readInt(); 
            int stateOfHealth = StdIn.readInt(); 
            Person person = new Person(id, ethnicity, gender, age, cause, urgency, stateOfHealth);
            addPerson(person, i);
        }
        return listOfPatients.length;
    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) 
    {
        survivabilityByAge = new SurvivabilityByAge[numberOfLines];
        for (int i = 0; i<numberOfLines; i++)
        {
            int age = StdIn.readInt();
            int years = StdIn.readInt();
            double rate = StdIn.readDouble();
        
            survivabilityByAge[i] = new SurvivabilityByAge(age, years, rate);        
        }
        return survivabilityByAge.length;
    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {
        // WRITE YOUR CODE HERE

        survivabilityByCause = new SurvivabilityByCause[numberOfLines];
        for (int i = 0; i<numberOfLines; i++)
        {
        int cause = StdIn.readInt();
        int years = StdIn.readInt();
        double rate = StdIn.readDouble();
    
        //SurvivabilityByCause surivabilitybycause = new SurvivabilityByCause(cause, years, rate);
        survivabilityByCause[i] = new SurvivabilityByCause(cause, years, rate);
        }
        //return the number of survivability rates read from file
        return survivabilityByCause.length;
    }
    
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with age above the parameter age.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) {
        int counter = 0; 
        int j =0;

        for (int i = 0; i<listOfPatients.length; i++)
        {
            if (listOfPatients[i].getAge() >= age) 
            {counter++;}}
        
        if (counter == 0) {
            return null;}
        else{
        Person[] listOfPatients1 = new Person[counter];
        for (int i = 0; i<listOfPatients.length; i++)
        {
            if (listOfPatients[i].getAge() >= age) 
            {listOfPatients1[j] = listOfPatients[i];
                j++;}}
            return listOfPatients1;
         }
        }
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the state of health equal to the parameter state.
     * 
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) {
       int counter = 0; 
       int j=0;

        for (int i = 0; i<listOfPatients.length; i++){
            if ((listOfPatients[i].getStateOfHealth()) == state)
                {counter++;}}

        if (counter==0){
            return null;
        }
        else
        {
        Person[] listOfPatients2 = new Person[counter];
        for (int i = 0; i<listOfPatients.length; i++)
        {
            if ((listOfPatients[i].getStateOfHealth()) == state)
            {listOfPatients2[j] = listOfPatients[i];
            j++;}
        }
            return listOfPatients2;} 
    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) 
    {
        int counter = 0; 
        for (int i = 0; i<listOfPatients.length; i++){
            if (listOfPatients[i].getCause() == cause)
            {counter++;}
        }

        if (counter==0){
            return null;
        }
        else{
        int j = 0;
        Person[] listOfPatients3 = new Person[counter];
        for (int i = 0; i<listOfPatients.length; i++){
            if (listOfPatients[i].getCause() == cause){
                listOfPatients3[j] = listOfPatients[i];
                j++;}}
            return listOfPatients3;
        } 
    }
    // /*
    //  * Assume there are numberOfHearts available for transplantation surgery.
    //  * Also assume that the hearts are of the same blood type as the
    //  * persons on the listOfPatients.
    //  * This method finds a set of persons to be the recepients of these
    //  * hearts.
    //  * 
    //  * The method returns a Person array from the listOfPatients
    //  * array that have the highest potential for survivability after
    //  * the transplant. The array size is numberOfHearts.
    //  * 
    //  * If numberOfHeartsAvailable is greater than listOfPatients
    //  * array size all Persons will receive a transplant.
    //  * 
    //  * If numberOfHeartsAvailable is smaller than listOfPatients
    //  * array size find the set of people with the highest
    //  * potential for survivability.
    //  * 
    //  * There is no correct solution, you may come up with any set of
    //  * persons from the listOfPatients array.
    //  */ 
     public Person[] match(int numberOfHearts) {
         Person[] a = listOfPatients.clone();
         int n = listOfPatients.length; 
         int personhealth1; 
         int personhealth2;

         for (int i = 1; i<n; i++)
         {
             for (int j = i; j>0; j--)
             {personhealth2 = (a[j]).getUrgency();
             personhealth1 = (a[j-1]).getUrgency();
             if (personhealth2 < personhealth1)
             {exch(a,j-1, j);} 
             else break;} 
         }

         for (int i = 1; i<n; i++)
         {
             for (int j = i; j>0; j--)
             {personhealth2 = (a[j]).getStateOfHealth();
             personhealth1 = (a[j-1]).getStateOfHealth();
             if (personhealth2 > personhealth1)
             {exch(a,j-1, j);} 
             else break;} 
         }

         if (numberOfHearts> a.length)
            {return a;}
        else
        {
            Person[] b = new Person[numberOfHearts];
            for (int i = 0; i< numberOfHearts; i++)
            {
                b[i] = a[i];
            }
        return b; 
        }
    }
         private static void exch(Person[] a, int i, int j)
         {
             Person t = a[i]; a[i] = a[j]; a[j] = t;}  

    /*
     * Client to test the methods you write
     */
    public static void main (String[] args) {

        HeartTransplant ht = new HeartTransplant();

        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");
 
        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file        
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        // list all patients
        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        // list survivability by age rates
        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        // list survivability by cause rates
        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
            StdOut.println(rate);
        }

        for (Person p : ht.match(10)) {
            StdOut.println(p);}
        
        System.out.println();

        for (Person p : ht.getPatientsByHeartConditionCause(3)) {
            StdOut.println(p);}

        System.out.println();

        for (Person p : ht.getPatientsWithAgeAbove(30)) {
            StdOut.println(p);}
    
        for (Person p : ht.getPatientsByStateOfHealth(5)){
           StdOut.println(p);}

         System.out.println("health");

        for (Person p : ht.getPatientsByStateOfHealth(5)){
            StdOut.println(p);}

            System.out.println("age");

        for (Person p : ht.getPatientsWithAgeAbove(200)) {
            StdOut.println(p);}
        
        System.out.println("cause");

        for (Person p : ht.getPatientsByHeartConditionCause(0)){
            StdOut.println(p);}
    }
}