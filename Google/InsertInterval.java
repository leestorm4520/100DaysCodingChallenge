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

    public static void main(String[] args){
        int[][] intervals={{1,3}, {6,9}};
        int[] newInterval={2,5};
        ArrayList<Interval> result=new ArrayList<Interval>();
        Interval temp;

        if(newInterval[1]<intervals[0][0]){
            temp.start=newInterval[0];
            temp.end=newInterval[1];
            result.add(temp);
            for(int i=0;i<intervals.length; i++) result.temp(new Interval());
        else if(newInterval[0]>intervals[intervals.length][1]]){
            for(int i=0;i<intervals.length; i++) result.put(intervals[i][0], intervals[i][1]);
            result.put(newInterval[0], newInterval[1]);
        }

        for(int i=0;i<intervals.length; i++) result.put(intervals[i][0], intervals[i][1]);


        int[][] finals=new int[result.size()][2];
        int i;
        for(Map.Entry<Integer, Integer> e: result.entrySet()){
            finals[i][0]=e.getKey();
            finals[i][1]=e.getValue();
        }
    }
}