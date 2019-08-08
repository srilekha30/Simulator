package os;
import java.util.*;
public class RoundRobin
{
	public float begin(int n,int bt[],int t)
	{	
		int waiting=0;
		int q1=t;
		for(int i=0;;i++)
		{	int q=q1;	
			if(i==n) i=0;
			if(bt[i]>0)
				bt[i]=bt[i]-q;
			else
				continue;
			if(bt[i]<0)
				q=q+bt[i];
			for(int j=0;j<n;j++)
			{
				if(j!=i && bt[j]>0)
				{
					waiting+=q;			
				}
			}
			boolean flag=true;
			for(int j=0;j<n;j++)
			{	
				if(bt[j]>0)
				{	
					flag=false;
					break;		
				}
			}
			if(flag)
				break;
		}
		//System.out.println("Round Robin: "+"\t\t"+(float)waiting/n);
		float ans=(float)waiting/n;
		return ans;
	       /* int i,j,temp;
	        //numberOfProcesses=rand.nextInt(3)+8;
	       // int arrivalTime[]=new int[numberOfProcesses];
	        //int executionTime[]=new int[numberOfProcesses];
	        int processId[]=new int[numberOfProcesses];
	        for(i=0;i<numberOfProcesses;i++){
	            for(j=i;j<numberOfProcesses;j++){
	                if(arrivalTime[j]<arrivalTime[i]){
	                    temp=arrivalTime[i];
	                    arrivalTime[i]=arrivalTime[j];
	                    arrivalTime[j]=temp;
	                    
	                    temp=executionTime[i];
	                    executionTime[i]=executionTime[j];
	                    executionTime[j]=temp;
	                    
	                    temp=processId[i];
	                    processId[i]=processId[j];
	                    processId[j]=temp;
	                }
	            }
	        }
	        int timer=0;
	        int waitingTime[]=new int[numberOfProcesses];
	        int execution2[]=new int[numberOfProcesses];
	        for(i=0;i<numberOfProcesses;i++)
	            execution2[i]=executionTime[i];
	        
	        //Queueing up elements.
	        Queue<Integer> aTQueue=new LinkedList<>();
	        Queue<Integer> eTQueue=new LinkedList<>();
	        Queue<Integer> eT2Queue=new LinkedList<>();
	        Queue<Integer> pIdQueue=new LinkedList<>();
	        for(i=0;i<numberOfProcesses;i++){
	            aTQueue.add(arrivalTime[i]);
	            eTQueue.add(executionTime[i]);
	            eT2Queue.add(execution2[i]);
	            pIdQueue.add(processId[i]);
	        }
	        while(aTQueue.size()>0){
	            if(eTQueue.peek()<=timeQuantum){
	                timer+=eTQueue.peek();
	                waitingTime[pIdQueue.peek()]=timer-aTQueue.peek()-eT2Queue.peek();
	                
	                eT2Queue.remove();
	                aTQueue.remove();
	                eTQueue.remove();
	                pIdQueue.remove();
	            }
	            else{
	                timer+=timeQuantum;

	                aTQueue.add(aTQueue.peek());
	                eTQueue.add(eTQueue.peek()-timeQuantum);
	                eT2Queue.add(eT2Queue.peek());
	                pIdQueue.add(pIdQueue.peek());
	                
	                eT2Queue.remove();
	                aTQueue.remove();
	                eTQueue.remove();
	                pIdQueue.remove();
	            }
	        }
	        int totalWaitingTime=0;
	        for(i=0;i<numberOfProcesses;i++)
	            totalWaitingTime+=waitingTime[i];
	        
	        float averageWaitingTime=(float)(totalWaitingTime/(numberOfProcesses*1.00));
	        return averageWaitingTime;*/
	}
}
