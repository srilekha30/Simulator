package os;
//import java.util.*;
//import java.util.Random;
public class FIFO {
	//public int main(int referenceString[],int numberOfPageRequests,int frameSize)
	public int main(int A[])
	{
		//Random ra=new Random();
		int Q[]=new int[3];
		Q[1]=-1;
		Q[2]=-1;
		int count=1;
		Q[0]=A[0];
		int i=1;
		while(A[i]==Q[0])
		{	
			i++;
			if(i==20) break;
		}
		if(i<20) 
		{
			Q[1]=A[i];
			count++;
			i++;
		}
		if(i<20)
		{
			while(A[i]==Q[0] || A[i]==Q[1])
			{
				i++;
				if(i==20) break;
			}
		}
		if(i<20)
		{
			Q[2]=A[i];
			count++;
			i++;
		}
		for(;i<20;i++)
		{
			int k=A[i];
			if(k==Q[0] || k==Q[1] || k==Q[2]){
			}
			else
			{	int m=Q[1];
				int n=Q[2];
				Q[2]=k;
				Q[1]=n;
				Q[0]=m;
				count++;
			}
		}
		return count;
		
		/*int i,pageFaults=0;
        Random rand=new Random();
        //int numberOfPageRequests=rand.nextInt(15)+6;
        //int frameSize=rand.nextInt(5)+3;
        //int referenceString[]=new int[numberOfPageRequests];
        //int numberOfPageRequests;
        /*for(i=0;i<numberOfPageRequests;i++)
            referenceString[i]=rand.nextInt(6);
        */
        //numberOfPageRequests=referenceString.length;
        //Generated data:
       // System.out.print("We have the following data:\nFrame Size= "+frameSize+"\nAnd reference string= ");
        //for(i=0;i<numberOfPageRequests;i++)
          //  System.out.print(referenceString[i]+" ");
        //System.out.println();
        //----
/*
        Queue<Integer> frame=new LinkedList<>();
        for(i=0;i<numberOfPageRequests;i++){
            if(frame.contains(referenceString[i]))
                continue;
            else{
                pageFaults++;
                frame.add(referenceString[i]);
                if(frame.size()>frameSize)
                    frame.remove();
            }
            //System.out.println(i+" "+frame);
        }
        return pageFaults;*/
	}
}
