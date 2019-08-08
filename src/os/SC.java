package os;



public class SC{
	public static int second_chance(int numberOfPageRequests,int frameSize,int referenceString[], int table[][]){
/*//		Random random = new Random();1
		//Scanner scan = new Scanner(System.in);
		int kk=1;
		int i,j,pointer=1,PageFaults,flag,flag1=1,l,m;
//		n = 1 + random.nextInt(20);
//		n = scan.nextInt();
//		Frames = scan.nextInt();
//		int Pages[]     = new int[21];
		int Memory[]    = new int[10];
		int Check[]     = new int[10];
		int PageFault[] = new int[21];		//0-PageFault.
		int Pointer[]   = new int[21];      //1-completed.   0-yet to be...
		int ReferenceBit[] = new int[10];
//		n = 20;
		PageFaults = 1;
		for(i=1;i<=n;i++){
		//	Pages[i] = 1 + random.nextInt(10);
//			Pages[i] = scan.nextInt();
			Pointer[i] = 0;
			System.out.printf("%d ",Pages[i]);
		}
		System.out.println("\n");
		for(i=1;i<=Frames;i++){
			Memory[i] = -1;
			ReferenceBit[i] = -1;
		}
		pointer = 1;
		Memory[1] = Pages[1];
		ReferenceBit[1] = 0;
		for(j=1;j<=Frames;j++){
			System.out.printf("%d ",Memory[j]);
			table[kk][j]=Memory[j];
		}
		kk++;
		System.out.println("\n");
		
		for(i=2;i<=n;i++){
			flag1 = 1;
			flag = 0;
			for(j=1;j<=Frames;j++){
				if(Pages[i]==Memory[j]){
					flag = 1;
					ReferenceBit[j] = 1;
					PageFault[i] = 1;
					break;
				}
			}
			if(flag == 1){
				PageFault[i] = 1;
				//Do nothing.
			}
			else{
				flag1 = 0;
				for(j=1;j<=Frames;j++){
					if(Memory[j] == -1){
						flag1 = 1;
						break;
					}
				}
				if(flag1==1){
					Memory[j] = Pages[i];
					PageFaults = PageFaults + 1;
					PageFault[i] = 0;
					ReferenceBit[j] = 0;
				}
			}
			if(flag1==0){
				int k;
				k = FindFault(Pointer,PageFault,Memory,ReferenceBit,n,Frames,Pages);
				for(j=1;j<=Frames;j++){
					if(Memory[j] == Pages[k]){
						Memory[j] = Pages[i];
						PageFault[i] = 0;
						PageFaults = PageFaults + 1;
						break;
					}
				}
			}			
			for(j=1;j<=Frames;j++){
				System.out.printf("%d ",Memory[j]);
				table[kk][j]=Memory[j];
			}
			kk++;
			System.out.println("\n");
		}
		System.out.println(PageFaults);
		for(j=1;j<=n;j++){
			System.out.printf("%d ",PageFault[j]);
		}
		System.out.println("\n");
		return PageFaults;
	}
	public static int FindFault(int Pointer[],int PageFault[],int Memory[],int ReferenceBit[],int n,int Frames,int Pages[]){
		int i,j;
		for(i=1;i<=n;i++){
			if(Pointer[i] == 0 && PageFault[i] == 0){
				for(j=1;j<=Frames;j++){
					if(Pages[i]==Memory[j] && ReferenceBit[j] == 1){
						ReferenceBit[j] = 0;
					}
					else if(Pages[i]==Memory[j] && ReferenceBit[j] == 0){
						Pointer[i] = 1;
						return i;
					}
				}
			}
		}
		return 0;*/
		int i,j,k,pageFaults=0,isPresent,z;
	       
        int secondChance[]=new int[10];

        for(i=0;i<10;i++)
            secondChance[i]=0;
       
        z=0;
        int frame[]=new int[frameSize];
        int dummyFrame[]=new int[frameSize];
        int dummyLength;
        int p;
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
            for (p=0;p<frameSize;p++) {
            	table[i][p]=frame[p];
            }
        }
        return pageFaults;
	}
}