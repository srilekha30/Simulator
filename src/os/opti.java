package os;

public class opti {
	public static int optimal(int numberOfPageRequests,int frameSize,int referenceString[], int table[][]){

		int i,j,k,pageFaults=0,isPresent,z,count,referenceCount,index;
      //  Random rand=new Random();
        
        z=0;
        int frame[]=new int[frameSize];
        
        for(i=0;i<frameSize;i++)
            frame[i]=-1;
        int p;
        System.out.println();
        for (p=0;p<frameSize;p++) {
        	System.out.print(frame[p]+" ");
        }
        System.out.println();
        for (p=0;p<numberOfPageRequests;p++) {
        	System.out.print(referenceString[p]+"-");
        }
        System.out.println();
        count=0;
        int count_t=0;
       
        referenceCount=0;
        while(count<frameSize && referenceCount<numberOfPageRequests){
            isPresent=0;
            for(j=0;j<frameSize;j++){
                if(referenceString[referenceCount]==frame[j]){
                    isPresent=1;
                    break;
                }
            }
            if(isPresent==0){
            	System.out.print("in while if ");
                for (p=0;p<frameSize;p++) {
                	System.out.print(frame[p]+" ");
                }
                frame[count]=referenceString[referenceCount];
                count++;
                System.out.print("in while after if ");
                for (p=0;p<frameSize;p++) {
                	System.out.print(frame[p]+" ");
                }

            }
            for (p=0;p<frameSize;p++) {
            	table[count_t][p]=frame[p];
            }
            
            System.out.println();
            referenceCount++;
            count_t++;
        }
        pageFaults=count;
        
        while(referenceCount<numberOfPageRequests){
            isPresent=0;
            for(j=0;j<frameSize;j++){
                if(referenceString[referenceCount]==frame[j]){
                    isPresent=1;
                    break;
                }
            }
            if(isPresent==0){
                pageFaults++;
                int indexOfRequest[]=new int[frameSize];
                for(i=0;i<frameSize;i++){
                    isPresent=0;
                    index=1000;
                    indexOfRequest[i]=index;
                    for(j=referenceCount;j<numberOfPageRequests;j++){
                        if(frame[i]==referenceString[j]){
                            isPresent=1;
                            index=j;
                            break;
                        }
                    } 
                    if(isPresent==1){
                        indexOfRequest[i]=index;
                    }
                }
                int toBeRemoved=0,maxIndex=indexOfRequest[0];
                for(j=1;j<frameSize;j++){
                    if(maxIndex<indexOfRequest[j]){
                        toBeRemoved=j;
                        maxIndex=indexOfRequest[j];
                    }
                }
                frame[toBeRemoved]=referenceString[referenceCount];
            }   
            referenceCount++;
            for (p=0;p<frameSize;p++) {
            	table[count_t][p]=frame[p];
            }
            count_t++;
            for (p=0;p<frameSize;p++) {
            	System.out.print(frame[p]+" ");
            }
            System.out.println();
        }
        System.out.print(frame);
        for (i=0;i<numberOfPageRequests;i++){
        	for(j=0;j<frameSize;j++){
        		System.out.print(table[i][j]+" ");
        	}
        	System.out.println();
        }
        return pageFaults;
	}
}
