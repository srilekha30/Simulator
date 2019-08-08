package os;
import java.util.*;
import java.util.Random;
public class CScan {
	public int main(int queue[],int numberOfRequests,int head)
	{	
	
		int i,j1,j2,totalHeadMovements;
        Random rand=new Random();
        int A[]=new int[numberOfRequests+3];
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
        int count=0;
        A[count]=head;
        count++;        
        totalHeadMovements=0;
        if(prevState>head){
            for(i=j1-1;i>=0;i--){
                totalHeadMovements+=head-lesserHead[i];
                head=lesserHead[i];
                A[count]=head;
                count++; 
            }
            totalHeadMovements+=head;
            A[count]=0;
            count++; 
            head=199;
            A[count]=head;
            count++; 
            totalHeadMovements+=199;
            for(i=j2-1;i>=0;i--){
                totalHeadMovements+=head-greaterHead[i];
                head=greaterHead[i];
                A[count]=head;
                count++; 
            }
        }
        else{
            for(i=0;i<j2;i++){
                totalHeadMovements+=Math.abs(greaterHead[i]-head);
                head=greaterHead[i];
                A[count]=head;
                count++; 
            }
            totalHeadMovements+=199-head;
            A[count]=199;
            count++; 
            head=0;
            totalHeadMovements+=199;
            A[count]=head;
            count++; 
            System.out.println();
            for(i=0;i<j1;i++){
                totalHeadMovements+=Math.abs(lesserHead[i]-head);
                head=lesserHead[i];
                A[count]=head;
                count++; 
            }   
        }
        Graph OBJ4=new Graph(A,numberOfRequests+3);
		OBJ4.test(A,numberOfRequests+3);
        return totalHeadMovements;
}
}
