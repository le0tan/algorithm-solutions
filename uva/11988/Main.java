import java.util.*;

public class Main {
	public static void main(String[] args) {
		String s;
		Scanner sc = new Scanner(System.in);
		LinkedList<Character> list;
		ListIterator<Character> it;
		while(sc.hasNext()) {
			s = sc.nextLine();
			list = new LinkedList<>();
			it = list.listIterator();
			int mode = 0; // 0 for normal, 1 for use it, 2 for append
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='[') {
					mode = 1;
					it = list.listIterator();
				} else if(s.charAt(i)==']') {
					mode = 2;
				} else if(mode == 0 || mode == 2) {
					list.add(s.charAt(i));
				} else {
					it.add(s.charAt(i));
				}
			}
			ListIterator<Character> iit = list.listIterator();
			StringBuilder sb = new StringBuilder();
			for(Character c: list) sb.append(c);
			System.out.println(sb);
		}
	}
}
