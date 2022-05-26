import java.util.*;


public class InsertInterval{

    public static void main(String[] args){
        int[][] intervals={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval={4,8};
        ArrayList<Interval> result=new ArrayList<Interval>();
        int i,j;
        int start=newInterval[0], end=newInterval[1];

       
        while(i<intervals.length && intervals[i][1]<start) result.add(new Interval(intervals[i++][0], intervals[i++][1]);

        while(i<intervals.length && intervals[i][0]<=end){
            start=Math.min(start, intervals[i][0]);
            end=Math.max(end, intervals[i][end]);
        }
        int[][] finals=new int[result.size()][2];
        for(i=0;i<finals.length;i++){
            finals[i][0]=result.get(i).start;
            finals[i][1]=result.get(i).end;
            System.out.printf("%d %d - ", finals[i][0], finals[i][1]);
        }
       
    }
}

/*
public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    
List<Interval> result = new ArrayList<>();
int i = 0;
int start = newInterval.start;
int end = newInterval.end;
    

while (i < intervals.size() && intervals.get(i).end < start) {
    result.add(intervals.get(i++));
}

while (i < intervals.size() && intervals.get(i).start <= end) {
    start = Math.min(start, intervals.get(i).start);
    end = Math.max(end, intervals.get(i).end);
    i++;
}
result.add(new Interval(start,end)); 

while (i < intervals.size()) result.add(intervals.get(i++)); 
return result;
}
*/