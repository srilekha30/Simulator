package os;

public class FCFS
{	
	public float begin(int n,int[] arr_time,int[] exec_time)
	{	
		for(int i=0;i<arr_time.length;i++)
        {
            for(int j=i+1;j<arr_time.length;j++)
            {
                if(arr_time[i]>arr_time[j])
                {
                    int temp=arr_time[i];
                    arr_time[i]=arr_time[j];
                    arr_time[j]=temp;
                    
                    temp=exec_time[i];
                    exec_time[i]=exec_time[j];
                    exec_time[j]=temp;
                }
            }
        }
		float sum=0;
        for (int i=0;i<exec_time.length;i++)
        {
            int temp=0;
            for(int j=0;j<i;j++)
            {
              temp+=exec_time[j];
            }
            if (temp>arr_time[i])
                sum+=(temp-arr_time[i]);
        }
        sum=sum/(float)n;
        return sum;
		
	}
}
