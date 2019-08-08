package os;


public class OPTIMAL {
	public static int main(int referenceString[],int numberOfPageRequests,int frameSize){
		
		
		int i,j,pageFaults=0,isPresent,count,referenceCount,index;

       
        int frame[]=new int[frameSize];
       
        for(i=0;i<frameSize;i++)
            frame[i]=-1;

        count=0;
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
                frame[count]=referenceString[referenceCount];
                count++;
            }
            referenceCount++;
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
        }
        return pageFaults;
	}
}