package algorithmProject;
//Java program to evaluate expression tree
import java.util.*;

public class GFG{
	
	Node root;

	// Class to represent the nodes of syntax tree
	public static class Node
	{
		String data;
		Node left, right;

		Node(String d)
		{
			data = d;
			left = null;
			right = null;
		}
}

	private static double toInt(String s){
		double num = 0;

		// Check if the integral value is
		// negative or not
		// If it is not negative, generate
		// the number normally
		if (s.charAt(0) != '-')
			for(int i = 0; i < s.length(); i++)
				num = num * 10 + ((double)s.charAt(i) - 48);
				
		// If it is negative, calculate the +ve number
		// first ignoring the sign and invert the
		// sign at the end
		else
			for(int i = 1; i < s.length(); i++)
			{
				num = num * 10 + ((double)(s.charAt(i)) - 48);
				num = num * -1;
			}
		return num;
	}

	// This function receives a node of the syntax
	// tree and recursively evaluate it
	public static double evalTree(Node root)
	{
		
		// Empty tree
		if (root == null)
			return 0;

		// Leaf node i.e, an integer
		if (root.left == null && root.right == null)
			return Double.parseDouble(root.data);

		// Evaluate left subtree
		double leftEval = evalTree(root.left);

		// Evaluate right subtree
		double rightEval = evalTree(root.right);

		// Check which operator to apply
		if (root.data.equals("+"))
			return leftEval + rightEval;

		if (root.data.equals("-"))
			return leftEval - rightEval;

		if (root.data.equals("*"))
			return leftEval * rightEval;

		return leftEval / rightEval;
	}

	// Driver code
	public static void createArray()
	{
		
		ArrayList<String> data = getDataArray();
		
		MergeSort mrg = new MergeSort();
		mrg.sortedArray(data);
		
		System.out.println("Mean of data = " + getMean(data));

	}
	
	public static ArrayList<String> getDataArray(){
		ArrayList<String> data = new ArrayList<String>();    
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i<5; i++){
			data.add(Double.toString(scanner.nextDouble()));
		}
		
		return data;
		
	}
	
	public static double getMean(ArrayList<String> arr){
		
		double sum = 0;
		Node root = new Node("+");
		root.left = new Node(arr.get(0));
		
		for(int i=1; i< arr.size(); i++){
			root.right = new Node(arr.get(i));
			root.left = new Node(Double.toString(evalTree(root)));
		}
		Node root2 = new Node("/");
		root2.left = root.left;
		root2.right = new Node(Integer.toString(arr.size()));
		
		double answer = evalTree(root2);
		return answer;	
	}

	public static String getMedian(ArrayList<String> a) {
		
		if (a.size() % 2 != 0) {
			int pos = (a.size() + 1)/2;
			System.out.print(pos);
			return a.get(pos-1);
		} else {
			int pos1 = a.size()/2;
			double median =( Double.parseDouble(a.get(pos1-1)) + Double.parseDouble(a.get(pos1)))/2;
			
			return Double.toString(median);
		}
	}
	
	public static double getVariance(ArrayList<String> v) {
		double v1 = 0;
		double getV = 0;
		if (v.size() > 1) {
			for (int i =0; i < v.size(); i++) {
				v1 += (Double.parseDouble(v.get(i)) - GFG.getMean(v))*(Double.parseDouble(v.get(i)) - GFG.getMean(v));
			}
			return getV = v1/(v.size()-1);
		} else {
			return getV = 0;
		}
	}
}

