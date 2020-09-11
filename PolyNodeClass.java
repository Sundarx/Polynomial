// SUNDAR RAJ
public class PolyNodeClass
{
	private int coefficient;
	private int exponent;
	private PolyNodeClass next;

	public PolyNodeClass()
	{
		this(0,0,null);
	}

	public PolyNodeClass(int coefficient, int exponent, PolyNodeClass next)
	{
		this.coefficient = coefficient;
		this.exponent = exponent;
		this.next = next;
	}

	public PolyNodeClass(PolyNodeClass pnc)
	{
		coefficient = pnc.coefficient;
		exponent = pnc.exponent;
		next = pnc.next;
	}

	public void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient;
	}

	public void setExponent(int exponent)
	{
		this.exponent = exponent;
	}

	public void setNext(PolyNodeClass next)
	{
		this.next = next;
	}

	public int getCoefficient()
	{
		return coefficient;
	}

	public int getExponent()
	{
		return exponent;
	}

	public PolyNodeClass getNext()
	{
		return next;
	}
}