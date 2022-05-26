import java.util.*;


public class InsertInterval{

    public static void main(String[] args){
        int[][] intervals={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval={4,8};
        ArrayList<Interval> result=new ArrayList<Interval>();
        int i,j;
        int startIndex=0, endIndex=0;

        if(newInterval[1]<intervals[0][0]){
        
            result.add(new Interval(newInterval[0], newInterval[1]));
            for(i=0;i<intervals.length; i++) result.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        else if(newInterval[0]>intervals[intervals.length-1][1]){
            for(i=0;i<intervals.length; i++) result.add(new Interval(intervals[i][0], intervals[i][1]));
            result.add(new Interval(newInterval[0], newInterval[1]));
        }
        else{
            for(i=0;i<intervals.length;i++){
                if(newInterval[0]>=intervals[i][0] && newInterval[0]<=intervals[i][1]){
                    startIndex=i;
                    break;
                }
            }
            
            for(i=startIndex;i<intervals.length;i++){
                if(newInterval[1]<=intervals[i][1] && newInterval[1]>=intervals[i][0]){
                    endIndex=i;
                    break;
                }
                else if(newInterval[1]<intervals[i][0]){
                    endIndex=i-1;
                }
                else{
                    endIndex=startIndex;
                }
            }


            for(i=0;i<intervals.length;i++){
                if(i==startIndex){
                    if(intervals[endIndex][1]>newInterval[1]) result.add(new Interval(intervals[i][0], intervals[endIndex][1]));
                    else result.add(new Interval(intervals[i][0], newInterval[1]));
                }
                else if(i>startIndex && i<=endIndex) continue;
                else{ result.add(new Interval(intervals[i][0], intervals[i][1]));}
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
