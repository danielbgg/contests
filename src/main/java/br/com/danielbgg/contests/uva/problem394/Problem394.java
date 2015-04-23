package br.com.danielbgg.contests.uva.problem394;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Problem 394
 * 
 * Mapmaker
 * 
 * http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=330
 */
class Problem394 {
	
	class Content {
		String name;
		int baseAddress;
		int size;
		int dim;
		int[][] dimension;
	}
	
	class Reference {
		String name;
		int[] indexes;
	}
	
	//n = number of arrays
	int n = 0;
	
	//r = number of array references for which addresses should be calculated
	int r = 0;
	
	//description of the arrays
	Content[] desc;
	
	//references of the arrays
	Reference[] ref;
	
	HashMap dimensions = new HashMap();

	void algorithm(String[] args) {
		description(args[0]);
		content(args);
		reference(args);
		output();
	}
	
	void description(String lineD) {
		StringTokenizer idata = new StringTokenizer(lineD);
		n = Integer.parseInt(idata.nextToken());
		r = Integer.parseInt(idata.nextToken());
	}
	
	void content(String[] args) {
		desc = new Content[n];
		for (int i = 1; i <= n; i++) {
			desc[i-1] = createContent(args[i]); 
        }
	}
	
	Content createContent(String lineN) {
		StringTokenizer idata = new StringTokenizer(lineN);
		Content ad = new Content();
		ad.name = idata.nextToken(); 
		ad.baseAddress = Integer.parseInt(idata.nextToken());
		ad.size = Integer.parseInt(idata.nextToken());
		int d = Integer.parseInt(idata.nextToken());
		ad.dim = d;
		dimensions.put(ad.name, ad);
		ad.dimension = new int[2][d];
		for (int i = 0; i < d; i++) {
			//lower
			ad.dimension[0][i] = Integer.parseInt(idata.nextToken());
			//upper
			ad.dimension[1][i] = Integer.parseInt(idata.nextToken());
        }
		return ad;
	}
	
	void reference(String[] args) {
		ref = new Reference[r];
		int offset = 1 + n;
		for (int i = offset; i < args.length; i++) {
			ref[i-offset] = createReference(args[i]);
        }
	}
	
	Reference createReference(String lineR) {
		StringTokenizer idata = new StringTokenizer(lineR);
		Reference ref = new Reference();
		ref.name = idata.nextToken();
		int d = ((Content) dimensions.get(ref.name)).dim;
		ref.indexes = new int[d];
		for (int i = 0; i < d; i++) {
			ref.indexes[i] = Integer.parseInt(idata.nextToken());
        }
		return ref;		
	}
	
	
//	The output file should contain the array references and the physical addresses. There should be one array reference and physical address per line. The formatting guidelines below must be adhered to.
//	For each line of output:
//	Output the name of the array
//	Output a left square bracket
//	Output each index value (each pair of indexes should have a single comma and space between them)
//	Output a right square bracket, a space, an equal sign, and another space
//	Output the physical address
//	ONE[2, 4] = 1526
//	THREE[7] = 3006
//	TWO[2, 0, 6] = 2148
//	TWO[3, 3, 9] = 2376	
	void output() {
		for (int i = 0; i < ref.length; i++) {
	        Reference r = ref[i];
	        System.out.println(r.name + Arrays.toString(r.indexes) + " = " + calculate(r));
        }
	}

	//THREE     3000 1  1  1 9
	String calculate(Reference r) {
		Content c = ((Content) dimensions.get(r.name));
		for (int i = 0; i < r.indexes.length; i++) {
			int index = r.indexes[i];
			
			int cd = c.size;
			int a = (c.dimension[1][i] - c.dimension[0][i] + 1);
			System.out.println(a);
			
	        
        }
		
		return null;
	}
	

	public static void main(String args[]) {
		Problem394 myWork = new Problem394();
		String[] s = new String[] {
		"3 4",
		"ONE       1500 2   2   0 3 1 5",
		"TWO       2000 4   3   1 4 0 5 5 10",
		"THREE     3000 1   1   1 9",
		"ONE       2 4",
		"THREE     7",
		"TWO       2 0 6",
		"TWO       3 3 9"		
		};
		myWork.algorithm(s);
		
		
//		N R
//		3 4
		
//		N Lines - each define an array, one per line		
//		Each line which defines an array contains, in the following order:
//		- the name of the array (which is limited to 10 characters), 
//		- a positive integer which specifies the base address of the array, 
//		- a positive integer which specifies the size in bytes of each array element, 
//		- and D, the number of dimensions in the array (no array will have fewer than 1 or more than 10 dimensions). 
//		- This is followed on the same line by D pairs of integers which represent the lower and upper bounds, respectively, of dimensions  1...D of the array.		
//		ONE       1500 2 2 0 3 1 5
//		TWO       2000 4 3 1 4 0 5 5 10
//		THREE     3000 1  1  1 9
		
//      R Lines - contain one array reference per line for which an address should be calculated
//      Each line which specifies an array reference contains 
//		- the name of the array followed by 
//		- the integer indexes  i1, i2, ..., iD where D is the dimension of the array.		
//		ONE       2 4
//		THREE     7
//		TWO       2 0 6
//		TWO       3 3 9		
		
		
	}

	static String readLn(int maxLg) {
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}
		if ((car < 0) && (lg == 0))
			return (null);
		return (new String(lin, 0, lg));
	}

	void begin() {
		String input;
		StringTokenizer idata;

		int line = 0;
		int n= 0;
		int r=0;
		
		while ((input = readLn(255)) != null) {
			idata = new StringTokenizer(input);
			
			if (line == 0) {
				n = Integer.parseInt(idata.nextToken());
				r = Integer.parseInt(idata.nextToken());
				line++;
			}
			
			
		}
		
		
		
		
		
	}
}
