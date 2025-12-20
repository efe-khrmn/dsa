class CountOnesOneInBinary {
    public static int countOnes(int n){
        if (n < 2) {
            return n;
        }
        return (n % 2) + countOnes(n / 2);
    }
}
class MaxDiff {
    public int maxDiff(int A[], int size){
        int i,j,best,soFar;
        i=0;best=0;
        for(j=0;j<size;j++){
            soFar=A[j]-A[i];
            if(soFar>best){
                best=soFar;
            }
            if(A[j]<A[i]){
                i=j;
            }
        }
        return best;
    }
}
class Gcd {
    public int gcd(int n1,int n2){
        if(n2==0){
            return n1;
        }
        return gcd(n2,n1%n2);
    }
}
class CountFigures {
    public int countFigures(int n){
        if(n<10){
            return 1;
        }
        return 1+countFigures(n/10);
    }
}
public class SampleMidterm{}