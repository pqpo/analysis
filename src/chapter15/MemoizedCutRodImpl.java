package chapter15;

/**
 * 动态规划-钢条切割问题,带备忘
 * @author pqpo
 *
 */
public class MemoizedCutRodImpl extends CutRod{
	

	@Override
	public int cut(int n) {
		int[] r = new int[n];
		for(int i=0;i<r.length;i++){
			r[i]=-1;
		}
		return memoizedCutRodAux(n,r);
	}
	
	public int memoizedCutRodAux(int n,int[] r){
		if(n==0) return 0;
		if(r[n-1]>=0){
			return r[n-1];
		}
		int q = 0;
		for(int i=1;i<=n;i++){
			int x = p[i] + memoizedCutRodAux(n-i,r);
			if(x>q) q = x;
		}
		r[n-1] = q;
		return q;
	}
	
	public static void main(String[] args) {
		CutRod cutRod = new MemoizedCutRodImpl();
		long time = System.currentTimeMillis();
		for(int i=1;i<=10;i++){
			System.out.println("长度为"+i+":"+cutRod.cut(i));
		}
		System.out.println("长度为31："+cutRod.cut(31));
		System.out.println("耗时："+(System.currentTimeMillis()-time)/1000+"s");
	}
	
}
