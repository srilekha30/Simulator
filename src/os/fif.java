package os;



//import java.util.Scanner;
public class fif {
	public static int fifo(int n,int Frames,int Pages[],int table[][]){
		//Random random = new Random();
		int k=0;
		int i,j,pointer=1,PageFaults,flag,flag1=1;

		int Memory[]    = new int[100];
		int PageFault[] = new int[21];

		PageFaults = 1;
		
		for(i=0;i<Frames;i++){
			Memory[i] = -1;
		}
		pointer = 0;
		Memory[0] = Pages[0];
		for(j=0;j<Frames;j++){
			table[k][j]=Memory[j];
		}
		k++;
		
		for(i=1;i<n;i++){
			flag1 = 1;
			flag = 0;
			for(j=0;j<Frames;j++){
				if(Pages[i]==Memory[j]){
					flag = 1;
					break;
				}
			}
			if(flag == 1){
				PageFault[i] = 1;

			}
			else{
				flag1 = 0;
				for(j=0;j<Frames;j++){
					if(Memory[j] == -1){
						flag1 = 1;
						break;
					}
				}
				if(flag1==1){
					Memory[j] = Pages[i];
					PageFaults = PageFaults + 1;
					PageFault[i] = 0;
				}
			}
			if(flag1==0){
				for(j=0;j<Frames;j++){
					if(Pages[pointer]==Memory[j]){
						Memory[j] = Pages[i];
						break;
					}
				}
				PageFaults = PageFaults + 1;
				PageFault[i] = 0;
				
				for(j=pointer+1;;j++){
					if(PageFault[j]==0){
						break;
					}
					pointer = pointer + 1;
				}
				pointer = pointer + 1;
			}
			for(j=0;j<Frames;j++){
				//System.out.printf("%d ",Memory[j]);
				table[k][j]=Memory[j];
			}
			k++;

		}
		return PageFaults;
	}
}