package os;

import java.util.Random;

public class nonpre_priority
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

        temp=readyQueue[j][3];
        readyQueue[j][3]=readyQueue[j+1][3];
        readyQueue[j+1][3]=temp;
    }
    public static void customSort(int[][] readyQueue,int start,int n){
        int i,j;
        for(i=start;i<n;i++)
            for(j=start;j<n-i-1+start;j++)
                if(readyQueue[j][3]>readyQueue[j+1][3])
                    swap(readyQueue,j);
                else if(readyQueue[j][3]==readyQueue[j+1][3] && readyQueue[j][1]>readyQueue[j+1][1])
                    swap(readyQueue,j);
    }
	public float begin(int numberOfProcesses,int arrivalTime[],int executionTime[],int priority[])
	{
		/*int [] et=new int[num+1];
		int [] st=new int[num+1];
		int [] vis=new int [num+1];
		int tot=0;	
		int temp=0;
		Random ra=new Random();
		for(int i=1;i<=num;i++)
		{
			tot=tot+bt[i];
			vis[i]=0;
		}
		int cnt=0,fff=0;
		while(true)
		{
			fff=0;
			for(int ss=1;ss<=num;ss++)
			{
				if(vis[ss]==1)
					fff++;
			}
			if(fff==num)
				break;
			int j=1;
			int dha=10000;
			int [] store=new int[num];
			int dd=0;
			for(int i=1;i<=num;i++)
			{
				if(at[i]<=cnt && vis[i]==0 && pr[i]<=dha)
				{
					dd=1;
					if(pr[i]==dha)
					{
						if(bt[store[j-1]]<bt[i])
						{
							
						}
						else
						{
							store[j]=i;
							j++;
							dha=pr[i];
						}
					}
					else
					{
						store[j]=i;
						j++;
						dha=pr[i];
					}
				}
			}
			if(dd==1)
			{
				int index=store[j-1];
				st[index]=cnt;
				et[index]=cnt+bt[index];
				cnt=et[index];
				vis[index]=1;
			}
			if(dd==0)
			cnt++;
		}
		float sum=0;
		int [] wt=new int[num+1];
		for(int i=1;i<=num;i++)
		{		
		 	wt[i]=st[i]-at[i];
		 	sum=sum+wt[i];
		}
		float sav=(float)sum/num;
		//System.out.println("NonPreemptive Priority: "+sav);
		return sav;*/
		int readyQueue[][]=new int[numberOfProcesses][4];
        int waitTill=0,count=0,time=0,process,rqPointer=0,frontPointer=0;
        int waitedFor[]=new int[numberOfProcesses];
        int i;
        while(count<numberOfProcesses){
            for(process=0;process<numberOfProcesses;process++){
                if(arrivalTime[process]==time){
                    readyQueue[rqPointer][0]=executionTime[process];
                    readyQueue[rqPointer][1]=arrivalTime[process];
                    readyQueue[rqPointer][2]=process;
                    readyQueue[rqPointer][3]=priority[process];
                    rqPointer++;
                    customSort(readyQueue,frontPointer,rqPointer);
                }
            }
            if(time>=waitTill && rqPointer-frontPointer>0){
                waitTill=time+readyQueue[frontPointer][0];
                waitedFor[readyQueue[frontPointer][2]]=time-readyQueue[frontPointer][1];
                frontPointer++;
                count++;
            }
            time++;
        }
        int totalSum=0;
        for(i=0;i<numberOfProcesses;i++)
            totalSum+=waitedFor[i];
        float averageWaitingTime=totalSum/numberOfProcesses;
        return averageWaitingTime;
		
	}
}