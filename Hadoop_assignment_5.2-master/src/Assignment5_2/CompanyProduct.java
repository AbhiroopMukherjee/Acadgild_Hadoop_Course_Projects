package Assignment5_2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
 
public class CompanyProduct implements WritableComparable<CompanyProduct> {
 
    private String company;
    private String product;
    private int size;
 
    public String getCompany() {
        return company;
    }
 
    public String getProduct() {
        return product;
    }
    
    public int getSize() {
        return size;
    }
 
    public void set(String company, String product, int size1) {
        this.company = company;
        this.product = product;
        this.size = size1;
    }
 
    @Override
    public void readFields(DataInput in) throws IOException {
    	company = in.readLine();
    	System.out.println("Company : " + company);
    	product = in.readLine();
    	System.out.println("Product : " + product);
    	size = in.readInt();
    	System.out.println("size : " + size);
    }
 
    @Override
    public void write(DataOutput out) throws IOException {
    	out.writeChars(company);
    	out.writeChars(product);
    	out.writeInt(size);
    }
 
    @Override
    public String toString() {
        return company + "\t" + product + "\t" + size;
    }
 
    @Override
    public int compareTo(CompanyProduct CompanyProduct) {
        int cmp = this.size - CompanyProduct.size;
 
        if (cmp == 0) {
            return 0;
        }else if(cmp < 0){
        	return -1;
        }else{
        	return 1;
        }
    }
 
    @Override
    public int hashCode(){
        return company.hashCode();
    }
 
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof CompanyProduct)
        {
        	CompanyProduct cp = (CompanyProduct) o;
            return (company == cp.getCompany() && product == cp.getProduct() && size == cp.getSize());
        }
        return false;
    }
  
}