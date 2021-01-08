package Assignment5_2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
 
public class TV implements WritableComparable<TV> {
 
	private String company;
    private int size;
 
    public String getCompany() {
        return company;
    }
 
    public int getSize() {
        return size;
    }
 
    public void set(String company, int size) {
        this.company = company;
        this.size = size;
    }
 
    @Override
    public void readFields(DataInput in) throws IOException {
    	company = in.readUTF();
    	size = in.readInt();
    }
 
    @Override
    public void write(DataOutput out) throws IOException {
    	out.writeUTF(company);
    	out.writeInt(size);
    }
 
    @Override
    public String toString() {
        return company + "\t" + size;
    }
 
    @Override
    public int compareTo(TV tv) {
        int cmp = company.compareTo(tv.company);
 
        if (cmp != 0) {
            return cmp;
        }
 
        return (-1) * (size - tv.getSize());
    }
 
    @Override
    public int hashCode(){
        return company.hashCode();
    }
 
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof TV)
        {
            TV tv = (TV) o;
            return company.equalsIgnoreCase(tv.company) && (size == tv.getSize());
        }
        return false;
    }

}