package fun;

public class checkfibonacci {
	
	    // A utility method that returns true if x is perfect square
        public String fibonacci(int x) {
        	
        int inputNumber = x;
         
        int firstTerm = 0;
         
        int secondTerm = 1;
         
        int thirdTerm = 0;
         int count=0;
        while (thirdTerm < inputNumber)
        {
            thirdTerm = firstTerm + secondTerm;
             
            firstTerm = secondTerm;
             
            secondTerm = thirdTerm;
            count++;
        }
         
        if(thirdTerm == inputNumber)
        {
            return "id is a fibonacci number";
        }
        else
        {
        	return "id is not a fibonacci number";
        }
    } 
	  
	    // Driver method  
	  

}
