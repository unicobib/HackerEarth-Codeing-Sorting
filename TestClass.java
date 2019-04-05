import java.util.*;

public class TestClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
		int N = sc.nextInt();
		String[] arr = new String[N+1];
		for(int i=0; i<=N; i++) {
			arr[i]= sc.nextLine();
		}
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		TreeMap<String,Integer> tMap = new TreeMap<String,Integer>();

		for(int i=1; i<=N; i++) {
			if(map.isEmpty()) {
				map.put(arr[i], 1);
			}else if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}

		List<Map.Entry<String,Integer>> list= new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
			public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){

				return (o1.getValue()).compareTo(o2.getValue());

			}

		});


		for(Map.Entry<String, Integer> l1: list) {
			if(tMap.isEmpty())
				tMap.put(l1.getKey(), l1.getValue());
			else if(tMap.containsValue(l1.getValue())) {
				tMap.put(l1.getKey(), l1.getValue());
			}else {
				tMap.forEach((k,v)->System.out.println(v+" "+k));
				tMap.clear();
				tMap.put(l1.getKey(), l1.getValue());
			}

		}
		tMap.forEach((k,v)->System.out.println(v+" "+k));

		}
	}

}
