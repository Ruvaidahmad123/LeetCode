class Pair{
    int pass;
    int total;
    Pair(int p,int t){
        pass=p;
        total=t;
    }
    double gain() {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }
}
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.gain(), a.gain()));
        int n=classes.length;
        for(int i=0;i<n;i++){
            Pair p=new Pair(classes[i][0],classes[i][1]);
            pq.offer(p);
        }
        while(extraStudents>0 && !pq.isEmpty()){
            Pair p=pq.poll();
            p.pass+=1;
            p.total+=1;
            pq.offer(p);
            extraStudents--;
        }
        double sum=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            sum+=(double)p.pass/p.total;
        }
        return sum/n;
    }
}