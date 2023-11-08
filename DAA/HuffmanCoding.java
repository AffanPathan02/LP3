import java.util.*;
class HuffmanNode{
    int item;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class ImplementComparator implements Comparator<HuffmanNode>{
    public int compare(HuffmanNode x, HuffmanNode y){
        return x.item - y.item;
    }
}
public class Main{
    public static HuffmanNode buildHuffman(char[] charArray,int[] charFreq){
        int n=charArray.length;
        PriorityQueue<HuffmanNode> q= new PriorityQueue<HuffmanNode>(n,new ImplementComparator());
        
        for (int i=0;i<n ;i++ ) {
            HuffmanNode hn= new HuffmanNode();
            hn.c=charArray[i];
            hn.item=charFreq[i];
            hn.left=null;
            hn.right=null;
            q.add(hn);
        }
        
        while(q.size()>1){
            HuffmanNode x= q.poll();
            HuffmanNode y= q.poll();
            HuffmanNode f = new HuffmanNode();
            
            f.item=x.item+y.item;
            f.c='-';
            f.left=x;
            f.right=y;
            q.add(f);
        }
        
        return q.poll();
    }
    
    public static void printHuffman(HuffmanNode root,String s){
        if(root.left == null && root.right==null && Character.isLetter(root.c)){
            System.out.println(root.c +" | " +s);
            return;
        }
        printHuffman(root.left,s + "0");
        printHuffman(root.right,s + "1");
    }
    
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of characters: ");
        int n = scanner.nextInt();

        char[] charArray = new char[n];
        int[] charfreq = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter character " + (i + 1) + ": ");
            charArray[i] = scanner.next().charAt(0);
            System.out.print("Enter frequency for character " + charArray[i] + ": ");
            charfreq[i] = scanner.nextInt();
        }

        HuffmanNode root = buildHuffman(charArray, charfreq);

        System.out.println(" Char | Huffman code ");
        System.out.println("--------------------");
        printHuffman(root, "");
    }
}
