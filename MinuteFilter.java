
public class MinuteFilter implements Filter {
	private int min;
	
	public MinuteFilter(int m) {
		min = m;
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getMinutes(id) <= min;
	}

}
