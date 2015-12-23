package chapter15;

public class BottomUpCutRodImpl extends CutRod {

	@Override
	public int cut(int n) {
		int[]r = new int[n+1];
		r[0] = 0;
		for(int j=1;j<=n;j++){
			int q = -1;
			for(int i=1;i<=j;i++){
				int x = p[i] + r[j-i];
				if(x>q) q=x;
			}
			r[j] = q;
		}
		return r[n];
	}

	public static void main(String[] args) {
		CutRod cutRod = new BottomUpCutRodImpl();
		long time = System.currentTimeMillis();
		for(int i=1;i<=10;i++){
			System.out.println("长度为"+i+":"+cutRod.cut(i));
		}
		System.out.println("长度为31："+cutRod.cut(31));
		System.out.println("耗时："+(System.currentTimeMillis()-time)/1000+"s");
	}
}
