package test;

class SimpleInterest{
	
	float principle;
	float interest;
	float si;
	
	public SimpleInterest(float principle, float interest) {
		this.principle=principle;
		this.interest=interest;
	}
	public float total(int years) {
		si=(principle*interest*years)/100;
		return si;
	}
	
}