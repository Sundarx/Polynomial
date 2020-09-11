// SUNDAR RAJ
public interface PolynomialADT
{
	// Returns true of Linked List is empty
	public abstract boolean isEmpty();

	// sets the first node given by user
	public abstract void setFirstNode(PolyNodeClass firstNode);

	// returns the first node in the Linked List
	public abstract PolyNodeClass getFirstNode();

	// adds node in the front of list with determinants given from user
	public abstract void addPolyNodeFirst(int coefficient, int exponent);

	// adds node in the end of te list with determinants given from user
	public abstract void addPolyNodeLast(int coefficient, int exponent);

	// adds node to the end of the list
	public abstract void addPolyNode(int coefficient, int exponent);

	// adds two linked lists (polynomials) together, to determine sum of polynomials
	public abstract PolynomialDataStrucClass addPolynomials(PolynomialDataStrucClass pdsc);
}