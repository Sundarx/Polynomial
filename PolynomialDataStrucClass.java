// SUNDAR RAJ
public class PolynomialDataStrucClass implements PolynomialADT
{
	private PolyNodeClass firstNode;
	private PolyNodeClass addNode;

	public PolynomialDataStrucClass()
	{
		firstNode = null;
	}

	public PolynomialDataStrucClass(PolyNodeClass firstNode)
	{
		this.firstNode = firstNode;
	}

	public PolynomialDataStrucClass(PolynomialDataStrucClass pdsc)
	{
		firstNode = pdsc.firstNode;
	}

	public boolean isEmpty()
	{
		return firstNode == null;
	}

	public void setFirstNode(PolyNodeClass firstNode)
	{
		this.firstNode = firstNode;
	}

	public PolyNodeClass getFirstNode()
	{
		return firstNode;
	}

	public void addPolyNodeFirst(int coefficient, int exponent)
	{
		if(isEmpty())
		{
			 firstNode = new PolyNodeClass(coefficient, exponent, null);
		}
		else
		{
			firstNode = new PolyNodeClass(coefficient, exponent, firstNode);
		}
	}

	public void addPolyNodeLast(int coefficient, int exponent)
	{
		if(isEmpty())
		{
			 firstNode = new PolyNodeClass(coefficient, exponent, null);
		}
		else
		{
			PolyNodeClass current = firstNode;
			while(current.getNext() != null)
			{
				current = current.getNext();
			}
			current.setNext(new PolyNodeClass(coefficient, exponent, null));
		}
	}

	public void addPolyNode(int coefficient, int exponent)
	{
		addPolyNodeLast(coefficient, exponent);
	}

	public PolynomialDataStrucClass addPolynomials(PolynomialDataStrucClass pdsc)
	{
		PolyNodeClass current = firstNode;
		boolean cDescending;
		int cDescend1 = current.getExponent();
		int cDescend2 = current.getNext().getExponent();
		if(cDescend1 > cDescend2)
		{
			cDescending = true;
		}
		else
		{
			cDescending = false;
		}


		PolyNodeClass addToCurr = pdsc.firstNode;
		boolean aDescending;
		int aDescend1 = addToCurr.getExponent();
		int aDescend2 = addToCurr.getNext().getExponent();
		if(aDescend1 > aDescend2)
		{
			aDescending = true;
		}
		else
		{
			aDescending = false;
		}

		int newCoeff = 0;
		int newExp = 0;
		PolynomialDataStrucClass newPoly = new PolynomialDataStrucClass();
		current = firstNode;
		addToCurr = pdsc.firstNode;

		// exponents descending from L to R
		if(cDescending == true && aDescending == true)
		{
			while(current != null && addToCurr != null)
			{
				if(current.getExponent() == addToCurr.getExponent())
				{
					newCoeff = current.getCoefficient() + addToCurr.getCoefficient();
					newExp = current.getExponent();
					current = current.getNext();
					addToCurr = addToCurr.getNext();
				}

				else if(current.getExponent() > addToCurr.getExponent())
				{
					newCoeff = current.getCoefficient();
					newExp = current.getExponent();
					current = current.getNext();
				}

				else //(current.getExponent() < addToCurr.getExponent())
				{
					newCoeff = addToCurr.getCoefficient();
					newExp = addToCurr.getExponent();
					addToCurr = addToCurr.getNext();
				}

				newPoly.addPolyNode(newCoeff, newExp);
			}

			if(current != null && addToCurr == null)
			{
				while(current != null)
				{
					newPoly.addPolyNode(current.getCoefficient(), current.getExponent());
					current = current.getNext();
				}
			}

			if(current == null && addToCurr != null)
			{
				while(addToCurr != null)
				{
					newPoly.addPolyNode(addToCurr.getCoefficient(), addToCurr.getExponent());
					addToCurr = addToCurr.getNext();
				}
			}
		}

		// exponents ascending from L to R
		if(cDescending == false && cDescending == false)
		{
			while(current != null && addToCurr != null)
			{
				if(current.getExponent() == addToCurr.getExponent())
				{
					newCoeff = current.getCoefficient() + addToCurr.getCoefficient();
					newExp = current.getExponent();
					current = current.getNext();
					addToCurr = addToCurr.getNext();
				}

				else if(current.getExponent() < addToCurr.getExponent())
				{
					newCoeff = current.getCoefficient();
					newExp = current.getExponent();
					current = current.getNext();
				}

				else //(current.getExponent() > addToCurr.getExponent())
				{
					newCoeff = addToCurr.getCoefficient();
					newExp = addToCurr.getExponent();
					addToCurr = addToCurr.getNext();
				}

				newPoly.addPolyNode(newCoeff, newExp);
			}

			if(current != null && addToCurr == null)
			{
				while(current != null)
				{
					newPoly.addPolyNode(current.getCoefficient(), current.getExponent());
					current = current.getNext();
				}
			}

			if(current == null && addToCurr != null)
			{
				while(addToCurr != null)
				{
					newPoly.addPolyNode(addToCurr.getCoefficient(), addToCurr.getExponent());
					addToCurr = addToCurr.getNext();
				}
			}
		}

		return newPoly;
	}

	public String toString()
 	{
		String str = "";
		PolyNodeClass current = firstNode;
		while(current.getNext() != null)
		{
			if(current.getExponent() == 0)
			{
				str += current.getCoefficient();
			}

			else if(Math.abs(current.getCoefficient()) == 1)
			{
				str += "x^" + current.getExponent();
			}

			else
			{
				str += Math.abs(current.getCoefficient()) + "x^" + current.getExponent();
			}

			if(current.getNext().getCoefficient() >= 0)
			{
				str += " + ";
			}
			else
			{
				str += " - ";
			}

			current = current.getNext();
		}

		// catch last node
		if(current.getExponent() == 0)
		{
			str += Math.abs(current.getCoefficient());
		}

		else if(Math.abs(current.getCoefficient()) == 1)
		{
			str += "x^" + current.getExponent();
		}

		else
		{
			str += Math.abs(current.getCoefficient()) + "x^" + current.getExponent();
		}

		return str;
	}
}
