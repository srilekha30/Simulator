package os;

public class SJF_non_preemptive
{
	 public static void swap(int[][] readyQueue,int j){
	        int temp;
	        temp=readyQueue[j][0];
	        readyQueue[j][0]=readyQueue[j+1][0];
	        readyQueue[j+1][0]=temp;

	        temp=readyQueue[j][1];
	        readyQueue[j][1]=readyQueue[j+1][1];
	        readyQueue[j+1][1]=temp;

	        temp=readyQueue[j][2];
	        readyQueue[j][2]=readyQueue[j+1][2];
	        readyQueue[j+1][2]=temp;
	    }
	    public static void customSort(int[][] readyQueue,int start,int n){
	        int i,j;
	        for(i=start;i<n;i++)
	            for(j=start;j<n-i-1+start;j++)
	                if(readyQueue[j][0]>readyQueue[j+1][0])
	                    swap(readyQueue,j);
	                else if(readyQueue[j][0]==readyQueue[j+1][0] && readyQueue[j][1]>readyQueue[j+1][1])
	                    swap(readyQueue,j);
	    }
	public float begin(int numberOfProcesses,int arrivalTime[],int executionTime[])
	{	
		int readyQueue[][]=new int[numberOfProcesses][3];
        int waitTill=0,count=0,time=0,process,rqPointer=0,frontPointer=0;
        int waitedFor[]=new int[numberOfProcesses];
		while(count<numberOfProcesses){
            for(process=0;process<numberOfProcesses;process++){
                if(arrivalTime[process]==time){
                    readyQueue[rqPointer][0]=executionTime[process];
                    readyQueue[rqPointer][1]=arrivalTime[process];
                    readyQueue[rqPointer][2]=process;
                    rqPointer++;
                    customSort(readyQueue,frontPointer,rqPointer);
                }
            }
            if(time>=waitTill && rqPointer-frontPointer>0){
                waitTill=time+readyQueue[frontPointer][0];
                //System.out.println("P"+readyQueue[frontPointer][2]+" started at "+time+" and ended at "+executionTime[readyQueue[frontPointer][2]]);
                waitedFor[readyQueue[frontPointer][2]]=time-readyQueue[frontPointer][1];
                frontPointer++;
                count++;
            }
            time++;
        }
        int totalSum=0;
        int i;
        for(i=0;i<numberOfProcesses;i++)
            totalSum+=waitedFor[i];
        float averageWaitingTime=(float)(totalSum/(numberOfProcesses*1.00));
        return averageWaitingTime;
	}
}