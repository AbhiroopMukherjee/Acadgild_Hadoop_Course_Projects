package Assignment6_3;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Task6_3Reducer extends Reducer<Text, Text, Text,IntWritable>
{	
	public static Map<String,Integer> map = new HashMap<String,Integer>();
	
	//private static int top=0;
	public void reduce(Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException
	{
		int counter = 0;
		for (Text value : values) {
			counter++;
		}

			//context.write(key, new IntWritable(counter));
		map.put(key.toString(), counter);

	}
	
	protected void cleanup(Context context) throws IOException, InterruptedException {
		List<Map.Entry<String, Integer>> list = sort();
		for(int i = 0 ;i < 3; i++){
			context.write(new Text(list.get(i).getKey()), new IntWritable(list.get(i).getValue()));
		}
		
		//System.out.println(map);
		
	}
	
	public List<Map.Entry<String, Integer>>  sort(){
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		//System.out.println("List = " + list);
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
				return -1 * e1.getValue().compareTo(e2.getValue());
			}
		});
		
		//System.out.println("List = " + list);
		
		//map = new HashMap<String, Integer>();
		/*for(Map.Entry<String, Integer> e : list){
			System.out.println(e.getKey() + " " + e.getValue());
		}*/
		
		return list;
		
	}
	
	
}

