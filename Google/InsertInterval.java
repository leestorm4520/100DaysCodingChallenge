import java.util.*;


public class InsertInterval{
    class Interval{
        int start;
        int end;    
        
        Interval(int start, int end){
            this.start=start;
            this.end=end;
        }
    }

    public void main(String[] args){
        int[][] intervals={{1,3}, {6,9}};
        int[] newInterval={2,5};
        ArrayList<Interval> result=new ArrayList<Interval>();
        Interval temp;
        int i,j;

        if(newInterval[1]<intervals[0][0]){
            result.add(new Interval(newInterval[0], newInterval[1]));
            for(i=0;i<intervals.length; i++) result.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        else if(newInterval[0]>intervals[intervals.length][1]){
            for(i=0;i<intervals.length; i++) result.add(new Interval(intervals[i][0], intervals[i][1]));
            result.add(new Interval(newInterval[0], newInterval[1]));
        }
        else{
            for(i=0;i<intervals.length;i++){
                if(newInterval[0]>intervals[i][0]){
                    for(j=i;j<intervals.length;j++){
                        if(newInterval[1]<intervals[j][1]) intervals[i][1]=intervals[j][1];
                    }
                    result.add(new Interval(intervals[i][0], intervals[j][1]));
                    i=j;
                }
                else{
                    result.add(new Interval(intervals[i][0], intervals[i][1]));
                }
            }
        }

        int[][] finals=new int[result.size()][2];
        for(i=0;i<finals.length;i++){
            finals[i][0]=result.get(i).start;
            finals[i][1]=result.get(i).end;
            System.out.printf("%d %d - ", finals[i][0], finals[i][1]);
        }
       
    }
}
