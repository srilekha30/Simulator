package os;


public class DFCFS{
	public int main(int queue[],int numberOfRequests,int head)
	{
		
		int i,totalHeadMovements;
		totalHeadMovements=0;
		totalHeadMovements+=Math.abs(head-queue[0]);
		int A[]=new int[numberOfRequests+1];
		A[0]=head;
		for(i=1;i<numberOfRequests;i++){
			A[i]=queue[i-1];
		    totalHeadMovements+=Math.abs(queue[i]-queue[i-1]);
		}
		A[i]=queue[numberOfRequests-1];
		Graph OBJ1=new Graph(A,numberOfRequests);
		OBJ1.test(A,numberOfRequests+1);
		return totalHeadMovements;
	}
}
