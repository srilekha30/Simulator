package os;

public class SSTF{
	public int main(int queue[],int numberOfRequests,int head)
	{
		int i,j,totalHeadMovements,size,mini,ind,count=0;
        //Random rand=new Random();
		
        //numberOfRequests=rand.nextInt(3)+8;
        //int queue[]=new int[numberOfRequests];
		int queue2[]=new int[numberOfRequests];
		int A[]=new int[numberOfRequests+2];
		totalHeadMovements=0;
		size=numberOfRequests;
		A[count]=head;
		count++;
		while(size>0){
			mini=Math.abs(head-queue[0]);
			ind=0;
			for(i=1;i<size;i++)
				if(mini>Math.abs(head-queue[i])){
					mini=Math.abs(head-queue[i]);
					ind=i;
				}
			head=queue[ind];
			totalHeadMovements+=mini;
			A[count]=queue[ind];
			count++;
			for(i=j=0;i<size;i++){
				if(i!=ind){
					queue2[j++]=queue[i];
					
				}
			}
			size--;
			for(i=0;i<size;i++)
				queue[i]=queue2[i];
		}
		A[count]=head;
		count++;
		Graph OBJ2=new Graph(A,numberOfRequests+1);
		OBJ2.test(A,numberOfRequests);
		return totalHeadMovements;
	}
}
