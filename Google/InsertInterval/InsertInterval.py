'''
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
'''
class Interval:
    def __init__(self, start, end):
        self.start=start
        self.end=end
    def insert(self, intervals, newInterval):
        s, e=newInterval.start, newInterval.end
        parts=merge, left, right=[],[],[] #divide intervals into left and right parts to merge 
        for i in intervals:
            parts[(i.end<s)-(i.start>e)].append(i) #in parts, there are merge, left, right [0][1][2].
                                                #intervals[i].end<newInterval.start - intervals[i].start> newInterval.end
                                                #the value will be 0, 1 and -1 (0-0, 1-1, 1-0, 0-1) corresponding to merge, left, and right respestively
                                                #merge happens when both false or both true
                                                #left happens when True-False
                                                #right happens when False-True
        #if merge is not empty then compare the starting interval with s - find min and compare the ending interval with e - find max
        if merge:
            s=min(s,merge[0].start)
            e=max(e,merge[-1].end)
        return left+ [Interval(s,e)] + right