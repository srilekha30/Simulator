package os;

import java.util.*;
public class Banker {
	public static void main(){
		int need[][],allocate[][],max[][],avail[][],np,nr,i,j;
		
		//Generating Random Input for max , allocate , avail matrices.
		Random rand=new Random();
		np=rand.nextInt(7)+3;
		nr=rand.nextInt(2)+3;
		need = new int[np][nr];
		max  = new int[np][nr];
		allocate = new int[np][nr];
		avail = new int[1][nr];
		//System.out.println("No. of processes = "+np);
		//System.out.println("No. of Resources = "+nr);
		for(i=0;i<np;i++)
			for(j=0;j<nr;j++){
				max[i][j]=rand.nextInt(7)+2;
				allocate[i][j]=rand.nextInt(max[i][j])+1;
			}
		for(j=0;j<nr;j++)
			avail[0][j]=rand.nextInt(7)+4;

		//Calculating Need Matrix
		for(i=0;i<np;i++)
			for(j=0;j<nr;j++)
				need[i][j]=max[i][j]-allocate[i][j];

		//Generated data...
			
		//----
		
		int done[]=new int[np],z=0;
		int allocatedOrder[] = new int[np];
		for(i=0;i<np;i++)
			done[i]=0;
		
		j=0;
		while(j<np){
			int isAllocated=0;
			for(i=0;i<np;i++){
				int allocatable=1;
				for(int k=0;k<nr;k++){
					if(avail[0][k]<need[i][k]){
						allocatable=0;
						break;
					}
				}

				if(done[i]==0 && allocatable==1){
					for(int k=0;k<nr;k++)
						avail[0][k]=avail[0][k]-need[i][k]+max[i][k];
					allocatedOrder[z]=i;
					z++;
					isAllocated=done[i]=1;
					j++;
				}
			}
			if(isAllocated==0) 
				break;
		}
		/*if(j==np){
			System.out.println("Safely Allocated");
			for(i=0;i<np;i++)
				System.out.print(allocatedOrder[i]+" ");
		}
		else{
			System.out.println("\nAll processes can't be allocated Safely");
			for(i=0;i<z;i++)
				System.out.print(allocatedOrder[i]+" ");
		}*/
		
	
			
			
		String t6;	
		if(j==np){
			
			t6="";
			t6=t6+"No. of processes = "+np;
			t6=t6+"\n";
			t6=t6+"No. of Resources = "+nr;
			t6=t6+"\n";
			
			t6=t6+"Allocation matrix:";
			t6=t6+"\n";
			//System.out.println("Allocation matrix:");
			for(i=0;i<np;i++) {
				for(j=0;j<nr;j++)
				{
					t6=t6+" "+allocate[i][j];
				}
				t6=t6+"\n";
			}
			
					//System.out.print(allocate[i][j]+" ");
			t6=t6+"max matrix:";
			t6=t6+"\n";
			//System.out.println("max matrix:");
			for(i=0;i<np;i++) {
				for(j=0;j<nr;j++)
				{
					t6=t6+" "+max[i][j];
				}
				t6=t6+"\n";
			}
			t6=t6+"Need matrix:";
			t6=t6+"\n";
			//System.out.println("Need matrix:");
			for(i=0;i<np;i++) {
				for(j=0;j<nr;j++)
				{
					t6=t6+" "+need[i][j];
				}
				t6=t6+"\n";
			}
			t6=t6+"Available matrix:";
			t6=t6+"\n";
			//System.out.println("Available matrix:");
				for(j=0;j<nr;j++)
				{
					t6=t6+" "+avail[0][j];
				}
				t6=t6+"\n";
				t6=t6+"Safely Allocated";
				t6=t6+"\n";
				//System.out.println("\nAll processes can't be allocated Safely");
				for(i=0;i<z;i++)
					t6=t6+allocatedOrder[i]+" ";
			
		}
		else{
			//String t6;
			t6="";
			t6=t6+"No. of processes = "+np;
			t6=t6+"\n";
			t6=t6+"No. of Resources = "+nr;
			t6=t6+"\n";
			
			t6=t6+"Allocation matrix:";
			t6=t6+"\n";
			//System.out.println("Allocation matrix:");
			for(i=0;i<np;i++) {
				for(j=0;j<nr;j++)
				{
					t6=t6+" "+allocate[i][j];
				}
				t6=t6+"\n";
			}
			
					//System.out.print(allocate[i][j]+" ");
			t6=t6+"max matrix:";
			t6=t6+"\n";
			//System.out.println("max matrix:");
			for(i=0;i<np;i++) {
				for(j=0;j<nr;j++)
				{
					t6=t6+" "+max[i][j];
				}
				t6=t6+"\n";
			}
			t6=t6+"Need matrix:";
			t6=t6+"\n";
			//System.out.println("Need matrix:");
			for(i=0;i<np;i++) {
				for(j=0;j<nr;j++)
				{
					t6=t6+" "+need[i][j];
				}
				t6=t6+"\n";
			}
			t6=t6+"Available matrix:";
			t6=t6+"\n";
			//System.out.println("Available matrix:");
				for(j=0;j<nr;j++)
				{
					t6=t6+" "+avail[0][j];
				}
				t6=t6+"\n";
			t6=t6+"All processes can't be allocated Safely";
			t6=t6+"\n";
			//System.out.println("\nAll processes can't be allocated Safely");
			for(i=0;i<z;i++)
				t6=t6+allocatedOrder[i]+" ";
		}
		SwingControlDemo oo=new SwingControlDemo();
		oo.main(t6);
	
}
	
}
