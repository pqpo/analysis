package chapter15;

/**
 * 动态规划-钢条切割问题
 * @author pqpo
 *
 */
public class CutRodImpl extends CutRod{
	@Override
	public int cut(int n) {
		if(n==0){
			return 0;
		}
		int q = 0;
		for(int i=1;i<=n;i++){
			int x = p[i] + cut(n-i);
			if(x>q) q = x;
		}
		return q;
	}
	
	public static void main(String[] args) {
		CutRod cutRod = new CutRodImpl();
		long time = System.currentTimeMillis();
		for(int i=1;i<=10;i++){
			System.out.println("长度为"+i+":"+cutRod.cut(i));
		}
		System.out.println("长度为31："+cutRod.cut(31));
		System.out.println("耗时："+(System.currentTimeMillis()-time)/1000+"s");
	}
	
}
