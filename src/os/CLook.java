package os;
import java.util.*;
public class CLook {

	public int main(int queue[],int numberOfRequests,int head)
	{	
		int i,j1,j2,totalHeadMovements;
        Random rand=new Random();
        int A[]=new int[numberOfRequests+1];
        //numberOfRequests=rand.nextInt(3)+8;
        //int queue[]=new int[numberOfRequests]; 
        Integer lesserHead[]=new Integer[numberOfRequests];
        Integer greaterHead[]=new Integer[numberOfRequests];
        int prevState;
        
        //for(i=0;i<numberOfRequests;i++)
            //queue[i]=rand.nextInt(200);
        //head=rand.nextInt(200);
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
       /* System.out.println("This is 200 requestIDs architecture\n");
            System.out.println("We have "+numberOfRequests+" number of requests.");
        for(i=0;i<numberOfRequests;i++)
            System.out.print(queue[i]+" ");
        System.out.println("\nAnd our head pointer is at "+head);
        System.out.println("And our previous head pointer was at "+prevState);*/
        //System.out.print(prevState);
        totalHeadMovements=0;
        int count=0;
        A[count]=head;
        count++;
        if(prevState>head){
            for(i=j1-1;i>=0;i--){
                totalHeadMovements+=Math.abs(head-lesserHead[i]);
                head=lesserHead[i];
                A[count]=head;
                count++;
            }
            for(i=j2-1;i>=0;i--){
                totalHeadMovements+=Math.abs(head-greaterHead[i]);
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

            for(i=0;i<j1;i++){
                totalHeadMovements+=Math.abs(lesserHead[i]-head);
                head=lesserHead[i];
                A[count]=head;
                count++;
            }   
        }
        
        Graph OBJ5=new Graph(A,numberOfRequests+1);
		OBJ5.test(A,numberOfRequests+1);
       return totalHeadMovements;
	}
	
	}
