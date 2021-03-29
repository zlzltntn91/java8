package stream.ex;

public class Student {

		String name;
		boolean isMale; // 성별
		int hak;		    // 학년
		int ban;		    // 반
		int score;

		public Student(String name, boolean isMale, int hak, int ban, int score) {
			this.name	= name;
			this.isMale	= isMale;
			this.hak	= hak;
			this.ban	= ban;
			this.score  = score;
		}

		public String	getName()  { return name;}
		public boolean isMale()    { return isMale;}
		public int		getHak()   { return hak;}
		public int		getBan()   { return ban;}
		public int		getScore() { return score;}

		public String toString() {
			return String.format("[%s, %s, %d학년 %d반, %3d점]",
								 name, isMale ? "남":"여", hak, ban, score);
		}
		// groupingBy()에서 사용
		enum Level { HIGH, MID, LOW }  // 성적을 상, 중, 하 세 단계로 분류
	}
