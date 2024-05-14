package num_7287;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class question_1406 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//문자열 받아오기
		String str = reader.readLine();
		
		//커서 위치 저장 변수
		//커서의 범위는 0(제일 왼쪽)부터 length(제일 오른쪽)까지
		int c = str.length();
		
		//문자열의 각 글자를 list에 저장하기
		ArrayList<String> list = new ArrayList<>();
		
		for (int i=0; i<str.length(); i++) {
			list.add(String.valueOf(str.charAt(i)));
		}
		
		//입력할 명령어 개수 m 받아오기
		int m = Integer.parseInt(reader.readLine());
		
		
		for (int i=0; i<m; i++) {
			String s = reader.readLine();
			
			//L : 왼쪽으로 한칸
			if (s.equals("L")) {
				if (c != 0) c--;
			}
			
			//D : 오른쪽으로 한칸
			else if (s.equals("D")) {
				if (c != list.size()) c++;
			}
			
			//B : 왼쪽 문자 삭제
			else if (s.equals("B")) {
				//ab(커서)cd인 경우 -> b를 삭제해야 함
				//이때 c=2이고, b의 index는 1
				//삭제하면 a(커서)cd
				if (c != 0) {
					c--;
					list.remove(c);
				}
			}
			
			//P $ : $라는 문자를 왼쪽에 추가
			else {
				//(커서)abcd인 경우 -> $(커서)abcd
				//c=0이었고 -> c=1이 되어야 함 & 0번째에 추가
				
				//ab(커서)cd인 경우 -> ab$(커서)cd
				//c=2였고 -> c=3이 되어야 함 & 2번째에 추가
				
				//abcd(커서)인 경우 -> abcd$(커서)
				//c=4였고 -> c=5가 되어야 함 & 4번째에 추가
				
				String[] s_p = s.split(" ");
				list.add(c, s_p[1]);
				c++;
			}

		}
		
		StringBuilder sb = new StringBuilder();
		
		for (String s : list) {
			sb.append(s);
		}
		
		System.out.println(sb);
		
		//편집기 예시
		//1. 입력 : P x -> abcdx(커서)
		//2. 입력 : L -> abcd(커서)x
		//3. 입력 : P y -> abcdy(커서)x
	}
}
