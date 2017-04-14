
public class MinMinuteFilter implements Filter {
	private int min;
	
	public MinMinuteFilter(int m) {
		min = m;
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getMinutes(id)>= min;
	}

}
