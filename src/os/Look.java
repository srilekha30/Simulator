package os;
import java.util.*;
public class Look {
	public int main(int queue[],int numberOfRequests,int head) {
        int i,j1,j2,totalHeadMovements;
        Random rand=new Random();
        //int queue[]=new int[numberOfRequests]; 
        Integer lesserHead[]=new Integer[numberOfRequests];
        Integer greaterHead[]=new Integer[numberOfRequests];
        int prevState;
        int A[]=new int[numberOfRequests+1];
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
                totalHeadMovements+=Math.abs(head-lesserHead[i]);
                head=lesserHead[i];
                A[count]=head;
                count++;
            }
            for(i=0;i<j2;i++){
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

            for(i=j1-1;i>=0;i--){
                totalHeadMovements+=Math.abs(lesserHead[i]-head);
                head=lesserHead[i];
                A[count]=head;
                count++;
            }   
        }
		Graph OBJ6=new Graph(A,numberOfRequests+1);
		OBJ6.test(A,numberOfRequests+1);
        return totalHeadMovements;
    }
}
