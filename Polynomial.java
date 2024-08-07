package Calculator;
import java.lang.*;

class Polynomial {
    public static void main(String[] args) {
	System.out.println("Hello");
   }
	
	public int order;
	public double[] coefficients;

	public Polynomial()
	{		
	}


	public Polynomial(double[] info)
	{
		order = info.length;
		// int realOrder = order-1;
		coefficients = new double[order];
		
		for (int i=0; i<info.length; i++)
		{
			coefficients[i]= info[i];
		}
	}

	
	public int getOrder()
	{
		return order;
	}


	public void displayPolynomial()
	{

		for(int i=0; i<order; i++)
		{

			if (coefficients[i] !=0.0){
			System.out.print(coefficients[i]);
			if (i!=0) {System.out.print("X^");
			System.out.print(i);}
			if (i+1<order) System.out.print(" + ");}
		}
	}


	public double getValueAt(double xValue)
	{
		double yValue=0.0;
		double x=0.0;
		for(int i=0; i<order; i++)
		{
			x = exponentiate(xValue, i);
			yValue = yValue + coefficients[i]*x;
		}
		return yValue;
	}


	public void displayValueAt(int xValue)
	{
		double yValue=0.0;
		for(int i=0; i<order; i++)
		{

			System.out.print(coefficients[i]+"*");
			if (i!=0) {System.out.print(xValue+"^");
			System.out.print(i);}
			else System.out.print(1);
			if (i+1<order) System.out.print(" + ");
		}
		System.out.print(" = ");
		System.out.print(getValueAt(xValue));
	}


	public double exponentiate(double base, int power)
	{
		double result=1;
		for(int i=0; i<power; i++)
		{
			result = result * base;
		}
		return result;
	}


	public void differentiate()
	{
		
		for(int i=0; i<order-1; i++)
		{
			coefficients[i]=coefficients[i+1]*(i+1);
		}
		coefficients[order-1]=0;
	}



	public double calculateZero(double start)
	{
		Polynomial polynomial1;
		Polynomial polynomial2;
		polynomial1 = new Polynomial(coefficients);
		polynomial2 = new Polynomial(coefficients);

		double a = start;
		double b = polynomial1.getValueAt(start);
		double c;
		polynomial2.differentiate();

		while (b>.0001 || b<-.0001)
		{
			b = polynomial1.getValueAt(a);
			c = polynomial2.getValueAt(a);
			a = a - (b/c);
		}
		return a;
    	}

}
