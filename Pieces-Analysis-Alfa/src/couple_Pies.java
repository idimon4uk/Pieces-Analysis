
public class couple_Pies {
	Pies m ;
	Pies n ;
	//public int m;
	//public int n;
	public couple_Pies(int m_, int n_, double mx, double my,double mz, double nx, double ny, double nz)
	{
		m = new Pies(m_,mx,my,mz);
		n = new Pies(n_,nx,ny,nz);
	}
}
