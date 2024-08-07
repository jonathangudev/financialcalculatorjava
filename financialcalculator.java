package Calculator;

class financialcalculator{
	public static void main(String[] args) {
	}

	public static double getFV(int valueN, double valueI, double valuePV, double valuePMT)
	{
		double[] coefficients = new double[(valueN+1)];
		for(int i=0; i<(valueN); i++)
		{
			coefficients[i]=valuePMT;
		}
		coefficients[(valueN)]=valuePV;
		Polynomial polynomial = new Polynomial(coefficients);
		return polynomial.getValueAt((1+valueI));
		
	}

	public static double geti(int valueN, double valuePV, double valueFV, double valuePMT)
	{
		double[] coefficients = new double[(valueN+1)];
		for(int i=0; i<(valueN); i++)
		{
			coefficients[i]=valuePMT;
		}
		coefficients[(valueN)]=valuePV;
		coefficients[0] = coefficients[0] - valueFV;
		Polynomial polynomial = new Polynomial(coefficients);
		return (polynomial.calculateZero((1))-1);
	}

	public static double getpmt(int valueN, double valueI, double valuePV, double valueFV)
	{
		double[] coefficients = new double[(valueN)];
		for(int i=0; i<(valueN); i++)
		{
			coefficients[i]=1;
		}
		Polynomial polynomial = new Polynomial(coefficients);
		double X = polynomial.getValueAt((1+valueI));
		double Y = valuePV*polynomial.exponentiate((1+valueI), valueN);
		return ((valueFV-Y)/X);
	}

	public static double getPV(int valueN, double valueI, double valueFV, double valuePMT)
	{
		double[] coefficients = new double[(valueN+1)];
		for(int i=1; i<(valueN+1); i++)
		{
			coefficients[i]=(valuePMT*-1.0);
		}
		coefficients[(valueN)]=coefficients[valueN] + valueFV;
		coefficients[0]=0;
		Polynomial polynomial = new Polynomial(coefficients);
		return polynomial.getValueAt((1.0/(1+valueI)));
		
	}

	public static int getn(double valueI, double valuePV, double valueFV, double valuePMT)
	{
		double currentValue=valuePV;
		int n=0;
		for (int i=0; currentValue<valueFV; i++)
		{
			currentValue = currentValue*(1+valueI) + valuePMT;
			n=n+1;
		}
		return (n-1);
	}	
}