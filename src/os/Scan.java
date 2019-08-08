package os;

import java.util.*;
public class Scan {
	public int main(int queue[],int numberOfRequests,int head)
	{	
	//	int next_to_m=find(A,n,m);
		/*int ans;
		if(head<100)
		{	int ma=max(A,n);
			ans=(head-0)+(ma-0);
		}
		else
		{	int mi=min(A,n);
			ans=(199-head)+(199-mi);
		}
		return ans;
	}
public static int max(int A[],int n)
{	int ma=A[0];
	for(int i=1;i<n;i++)
	{
		if(A[i]>ma) ma=A[i];
	}
	return ma;
}
public static int min(int A[],int n)
{	int mi=A[0];
	for(int i=1;i<n;i++)
	{
		if(A[i]<mi) mi=A[i];
	}
	return mi;*/
		int i,j1,j2,totalHeadMovements,count,maxi,mini,ind,positives,count1=0;
        Random rand=new Random();

        //int queue[]=new int[numberOfRequests]; 
        int A[]=new int[numberOfRequests+2];

        Integer lesserHead[]=new Integer[numberOfRequests];
        Integer greaterHead[]=new Integer[numberOfRequests];

        int prevState;
        prevState=rand.nextInt(200);

        j1=0;
        j2=0;
        for(i=0;i<numberOfRequests;i++)
            if(queue[i]<=head){
                lesserHead[j1]=queue[i];
                j1++;
            }
            else{
                greaterHead[j2]=queue[i];
                j2++;
            }
        Arrays.sort(lesserHead,0,j1);
        Arrays.sort(greaterHead,0,j2);

        //All data
        /*System.out.println("This is 200 requestIDs architecture\n");
            System.out.println("We have "+numberOfRequests+" number of requests.");
        for(i=0;i<numberOfRequests;i++)
            System.out.print(queue[i]+" ");
        System.out.println("\nAnd our head pointer is at "+head);
        System.out.println("And our previous head pointer was at "+prevState);
*/
        A[count1]=head;
        count1++;
        totalHeadMovements=0;
        if(prevState>head){
            for(i=j1-1;i>=0;i--){
                totalHeadMovements+=Math.abs(head-lesserHead[i]);
                head=lesserHead[i];
                A[count1]=head;
        		count1++;
            }
            totalHeadMovements+=head-0;
            head=0;
            A[count1]=head;
        	count1++;
            for(i=0;i<j2;i++){
                totalHeadMovements+=Math.abs(head-greaterHead[i]);
                head=greaterHead[i];
                A[count1]=head;
        		count1++;
            }
        }
        else{
            for(i=0;i<j2;i++){
                totalHeadMovements+=Math.abs(greaterHead[i]-head);
                head=greaterHead[i];
                A[count1]=head;
        		count1++;
            }
            totalHeadMovements+=199-head;
            head=199;
            A[count1]=head;
        	count1++;
            System.out.println();
            for(i=j1-1;i>=0;i--){
                totalHeadMovements+=Math.abs(lesserHead[i]-head);
                head=lesserHead[i];
                A[count1]=head;
        		count1++;
            }   
        }
        
       // System.out.println("\nTotal number of head movements = "+totalHeadMovements);
		Graph OBJ3=new Graph(A,numberOfRequests+2);
		OBJ3.test(A,numberOfRequests+2);
		return totalHeadMovements;
}
}
