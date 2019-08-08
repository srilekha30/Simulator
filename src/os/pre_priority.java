package os;

public class pre_priority
{
	 public static void swap(int[][] heap,int j){
	        int temp;
	        temp=heap[j][0];
	        heap[j][0]=heap[j+1][0];
	        heap[j+1][0]=temp;

	        temp=heap[j][1];
	        heap[j][1]=heap[j+1][1];
	        heap[j+1][1]=temp;

	        temp=heap[j][2];
	        heap[j][2]=heap[j+1][2];
	        heap[j+1][2]=temp;

	        temp=heap[j][3];
	        heap[j][3]=heap[j+1][3];
	        heap[j+1][3]=temp;
	    }
	    public static void customSort(int[][] heap,int start,int n){
	        int i,j;
	        for(i=start;i<n;i++)
	            for(j=start;j<n-i-1+start;j++)
	                if(heap[j][3]>heap[j+1][3])
	                    swap(heap,j);
	                else if(heap[j][3]==heap[j+1][3] && heap[j][1]>heap[j+1][1])
	                    swap(heap,j);
	    }
	public float begin(int numberOfProcesses,int arrivalTime[],int executionTime[],int priority[])
	{
		
		int i,j,someRandom,small;
		int processId[]=new int[numberOfProcesses];
        int finishedAt[]=new int[numberOfProcesses];
        int waitedFor[]=new int[numberOfProcesses];
        int totalBurstTime=0,flag=0,time;
		int heap[][]=new int[numberOfProcesses][4];
        int heapSize=0,peek=0,count=0;
        for(time=0;time<totalBurstTime || count<numberOfProcesses;time++){
            //System.out.println("\nNow time= "+time);
            //If a process just completed...
            if(/*if there are elements in heap*/heapSize-peek>0 && heap[peek][0]==0){
                finishedAt[heap[peek][2]]=time;
                //System.out.println("P"+heap[peek][2]+" completed");
                waitedFor[heap[peek][2]]=time-arrivalTime[heap[peek][2]]-executionTime[heap[peek][2]];
                count++;
                //pop it
                peek++;
            }
            //To add incoming processes.
            for(j=0;j<numberOfProcesses;j++){
                if(arrivalTime[j]==time){
                    heap[heapSize][0]=executionTime[j];
                    heap[heapSize][1]=arrivalTime[j];
                    heap[heapSize][2]=j;
                    heap[heapSize][3]=priority[j];
                    heapSize++;
                    customSort(heap,peek,heapSize);
                    //System.out.println("P"+j+" came in");
                }
            }
            if(heapSize-peek>0)
                heap[peek][0]-=1;
        }
        for(i=0;i<numberOfProcesses;i++)
            System.out.print(waitedFor[i]+" ");
        int totalSum=0;
        for(i=0;i<numberOfProcesses;i++)
            totalSum+=waitedFor[i];
        float averageWaitingTime=(float)(totalSum/(numberOfProcesses*1.00));
        return averageWaitingTime;
	}	
}