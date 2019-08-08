package os;

public class Secondchance 
{
	public int main(int referenceString[],int numberOfPageRequests,int frameSize)
	{	
		
		int i,j,k,pageFaults=0,isPresent,z;
       
        int secondChance[]=new int[10];

        for(i=0;i<10;i++)
            secondChance[i]=0;
       
        z=0;
        int frame[]=new int[frameSize];
        int dummyFrame[]=new int[frameSize];
        int dummyLength;
        for(i=0;i<numberOfPageRequests;i++){
            isPresent=0;
            if(z<frameSize){
                for(j=0;j<z;j++)
                    if(referenceString[i]==frame[j])
                        isPresent=1;
                if(isPresent==1)
                    secondChance[referenceString[i]]=1;
                else{
                    pageFaults++;
                    frame[z++]=referenceString[i];
                    secondChance[referenceString[i]]=0;
                }
            }
            else{
                for(j=0;j<frameSize;j++)
                    if(referenceString[i]==frame[j])
                        isPresent=1;
                if(isPresent==1)
                    secondChance[referenceString[i]]=1;
                else{
                    pageFaults++;
                    j=0;
                    dummyLength=0;
                    while(j<frameSize && secondChance[frame[j]]==1){
                        secondChance[frame[j]]=0;
                        dummyFrame[dummyLength++]=frame[j];
                        j++;
                    }
                    if(j==frameSize){//All elements have had a second chance.
                        frame[0]=referenceString[i];
                        secondChance[referenceString[i]]=0;
                        for(i=1;i<dummyLength;i++)
                            frame[i]=dummyFrame[i];
                    }
                    else{
                       
                        z=0;
                      
                        for(k=j+1;k<frameSize;k++)
                            frame[z++]=frame[k];
                        for(k=0;k<dummyLength;k++)
                            frame[z++]=dummyFrame[k];
                        frame[z++]=referenceString[i];
                        secondChance[referenceString[i]]=0;
                    }
                }
            }
        }
        return pageFaults;
}
}