package InsertInterval;
import java.util.*;


public class InsertInterval{

    public static void main(String[] args){
        int[][] intervals={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval={4,8};
        ArrayList<Interval> result=new ArrayList<Interval>(); //create an arraylist called result
        int i=0;
        int start=newInterval[0], end=newInterval[1];

        while(i<intervals.length && intervals[i][1]<start){
            result.add(new Interval(intervals[i][0], intervals[i][1]));
            i++;
        }
        //main logic for manipulating the interval
        /*
        if the current starting interval is less than the given ending interval
            find the min for the starting index
            find the max for the ending index
        */
        while(i<intervals.length && intervals[i][0]<=end){
            start=Math.min(start, intervals[i][0]);
            end=Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new Interval(start, end));
        while(i<intervals.length){
            result.add(new Interval(intervals[i][0], intervals[i][1]));
            i++;
        }
        int[][] finals=new int[result.size()][2];
        for(i=0;i<finals.length;i++){
            finals[i][0]=result.get(i).start;
            finals[i][1]=result.get(i).end;
            System.out.printf("%d %d - ", finals[i][0], finals[i][1]);
        }
       
    }
}
