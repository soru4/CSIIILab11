public class JavaLinkedList
{
 
    /**
     *  Default Constructor
     *  Create a new MyLinkedList of Integers
     */
    MyLinkedList<Integer> x ;
    public JavaLinkedList()
    {
        x = new MyLinkedList<Integer>();
    }

    /**
     *  Create a new MyLinkedList of Integers from the array
     */
    public JavaLinkedList(int[] nums)
    {
        for(int i = 0; i < nums.length; i++){
            x.add(nums[i]);
        }
    }

    /**
     *  Return the sum of all the items in the list
     */
    public double getSum( )
    {
        double total=0;
        for(int i  =0; i < x.size(); i++){
            total += x.get(i);
        }
        return total;
    }

    /**
     *  Return the mean of all the items in the list
     */
    public double getMean(  )
    {
        double mean  = getSum() / x.size();
        return mean;
    }
    
    /**
     *  Return the largest item in the list
     */
    public int getLargest()
    {
        int largest=Integer.MIN_VALUE;
           for(int i  =0; i < x.size(); i++){
            if(x.get(i ) > largest){
                largest = x.get(i);
            }
        }
        return largest;
    }

    /**
     *  Return the smallest item in the list
     */
    public int getSmallest()
    {
        int smallest = Integer.MAX_VALUE;
          for(int i  =0; i < x.size(); i++){
            if(x.get(i ) < smallest){
                smallest = x.get(i);
            }
        }
        return smallest;
    }

    /**
     *  Return a string with this format:
     *  
     *  SUM:: 10.0
     *  MEAN:: 4.65
     *  SMALLEST:: -1.23
     *  LARGEST:: 5.0
     */
    public String toString()
    {
        String output="";
        output += "SUM:: " + getSum() + "\n";
        output += "MEAN:: " + getMean() + "\n";
        output += "SMALLEST:: " + getSmallest() + "\n";
        output += "LARGEST:: " + getLargest() + "\n"; 
        return output;
    }
}